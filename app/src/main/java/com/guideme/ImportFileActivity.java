package com.guideme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;



import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.FileUtils;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.garmin.fit.csv.CSVTool;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.guideme.Model.DatabaseController;
import com.guideme.Model.FitData;
import com.guideme.Model.FitRowData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class ImportFileActivity extends AppCompatActivity {
    public static final int PICKEDFILERESULTINT = 1;
    private static final int STORAGE_PERMISSION_CODE = 101;

    private Uri fileUri;
    private String filePath;
    private String[] realFilePath;

    private static int progress;
    private ProgressBar progressBar;
    private boolean progressStatus = false;
    private Button importButton;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestLocationPermission();
        setContentView(R.layout.activity_import_file);
    }

    // Function to check and request permission
    private void requestLocationPermission() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    recreate();
                }
                return;

            case 2:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    recreate();
                }
                return;
        }
    }

    //Start process of file import when Button is clicked
    public void onClickImport(View view) {
        Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
        chooseFile.setType("application/octet-stream");
        chooseFile = Intent.createChooser(chooseFile, "Choose fit file for import");
        startActivityForResult(chooseFile, PICKEDFILERESULTINT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        setContentView(R.layout.activity_import_file);
        importButton = (Button) findViewById(R.id.btn_import);
        progress = 0;
        progressBar = (ProgressBar) findViewById(R.id.ImportProgressBar);
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setMax(200);
        importButton.setEnabled(false);

        //Thread for import process
        new Thread(new Runnable() {
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
                //start the import of the fitfile
                progressStatus = importProcess();
                handler.post(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 200; i++) {
                            progressBar.setProgress(i);
                        }
                    }
                });

                //show toast after import is finished
                handler.post(new Runnable() {
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        if(progressStatus){
                            Toast.makeText(getApplicationContext(), "Upload finished.", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Upload failed", Toast.LENGTH_SHORT).show();
                        }
                        importButton.setEnabled(true);

                        recreate();
                    }
                });
            }

            private boolean importProcess() {
                switch (requestCode) {
                    case PICKEDFILERESULTINT:
                        if (resultCode == -1) {

                            //Getting the filepath of the selected fitfile
                            fileUri = data.getData();
                            filePath = fileUri.getPath();
                            realFilePath = fileUri.getLastPathSegment().split(":");
                            if(Build.VERSION.SDK_INT>=29 && !realFilePath[1].contains("/storage/emulated/0/")) {
                                realFilePath[1] = "/storage/emulated/0/" + realFilePath[1];
                            }
                            //if picked file is a fitfile the process can proceed
                            if (filePath.toUpperCase().endsWith(".FIT")) {
                                try {
                                    //create csv and upload data to database
                                    createCSV(realFilePath[1]);
                                    //delete the temporary csv files from storage
                                    deleteTemporaryCSV("/storage/emulated/0/Download/out.csv");
                                    deleteTemporaryCSV("/storage/emulated/0/Download/out_data.csv");
                                    deleteTemporaryCSV("/storage/emulated/0/Download/out_dataFixed.csv");

                                } catch (Exception e) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        }
                        return true;
                }
                return true;
            }
        }).start();
    }

    //deleting temporary csv files only needed to parse data
    public void deleteTemporaryCSV(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    public void createCSV(String filePath) throws Exception {
        Constructor<CSVTool> csvCons = CSVTool.class.getDeclaredConstructor();
        csvCons.setAccessible(true);
        CSVTool toCSV = csvCons.newInstance();
        String[] arg = {"-b", filePath, "/storage/emulated/0/Download/out.csv", "--data"};
        //generate csv file from uploaded fitfile
        toCSV.main(arg);
        //make the generated csv file into a csv compliant filelayout
        makeItCSVCompliant("/storage/emulated/0/Download/out_data.csv");
        //transform csv to an object of of class FitData
        createDataObjectFromCSV("/storage/emulated/0/Download/out_dataFixed.csv");
    }
    //will change the garmincsv to a generic csv compliant version
    public void makeItCSVCompliant(String filepath) throws IOException {
        InputStream inputStream = new FileInputStream(filepath);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/storage/emulated/0/Download/out_dataFixed.csv"));
        String record = "";
        int lineCounter = 0;
        while ((record = br.readLine()) != null) {
            if (lineCounter == 0) {
                record = record + "makeItCSVCompliant";

            }
            bw.write(record);
            bw.newLine();
            lineCounter++;
        }
        br.close();
        bw.close();

    }

    //Read relevant data from the csv file and make a FitData object that's uploaded to database
    public void createDataObjectFromCSV(String filePath) throws IOException, IllegalAccessException {
        Reader in = new FileReader(filePath);
        //read data from csv file
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(',').withFirstRecordAsHeader().parse(in);
        //list of FitRowData to store the data from the csv
        ArrayList<FitRowData> list = new ArrayList<>();

        //iterate through csv file data
        //create FitRowData Objects and add them to list
        for (CSVRecord record : records) {
            boolean allColumnsNull = true;
            FitRowData newRow = new FitRowData();

            //Get Timestamp of every entry
            if (record.isSet("record.timestamp[s]")) {
                if (!record.get("record.timestamp[s]").isEmpty()) {
                    newRow.setTimestamp(Long.parseLong(record.get("record.timestamp[s]")));
                    allColumnsNull = false;
                }
            }

            //Get coordinates of every entry
            if (record.isSet("record.position_lat[semicircles]")
                    && record.isSet("record.position_long[semicircles]")
                    && record.isSet("record.altitude[m]")) {
                if (!record.get("record.position_lat[semicircles]").isEmpty()
                        && !record.get("record.position_long[semicircles]").isEmpty()
                        && !record.get("record.altitude[m]").isEmpty()) {
                    newRow.setCoordinate(correctCoordinate(Double.parseDouble(record.get("record.position_lat[semicircles]"))),
                            correctCoordinate(Double.parseDouble(record.get("record.position_long[semicircles]"))),
                            Double.parseDouble(record.get("record.altitude[m]")));
                    allColumnsNull = false;
                }
            }
            //Get current distance since start
            if (record.isSet("record.distance[m]")) {
                if (!record.get("record.distance[m]").isEmpty()) {
                    newRow.setDistance(Double.parseDouble(record.get("record.distance[m]")));
                    allColumnsNull = false;
                }
            }
            //Get current speed
            if (record.isSet("record.speed[m/s]")) {
                if (!record.get("record.speed[m/s]").isEmpty()) {
                    newRow.setCurrentSpeed(Double.parseDouble(record.get("record.speed[m/s]")));
                    allColumnsNull = false;
                }
            }
            //Get current power
            if (record.isSet("record.power[watts]")) {
                if (!record.get("record.power[watts]").isEmpty()) {
                    newRow.setCurrentPower(Integer.parseInt(record.get("record.power[watts]")));
                    allColumnsNull = false;
                }
            }
            //Get current temperature
            if (record.isSet("record.temperature[C]")) {
                if (!record.get("record.temperature[C]").isEmpty()) {
                    newRow.setCurrentTemperature(Integer.parseInt(record.get("record.temperature[C]")));
                    allColumnsNull = false;
                }
            }
            //Get current cadence
            if (record.isSet("record.cadence[rpm]")) {
                if (!record.get("record.cadence[rpm]").isEmpty()) {
                    newRow.setCurrentCadence(Double.parseDouble(record.get("record.cadence[rpm]")));
                    allColumnsNull = false;
                }
            }

            //Add the data to the list if a row was parsed
            if (allColumnsNull == false) {
                list.add(newRow);
            }
        }


        if (!list.isEmpty()) {
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
            //Create FitData object with data from the csv
            FitData fitData = new FitData(currentUser.getUid(), list, "Route_beginn_" + convertTime(list.get(1).getTimestamp()));
            //Create an instance of the DatabaseController and upload new FitData object to database
            DatabaseController databaseController = DatabaseController.getInstance(fitData.getUserId());
            databaseController.addFitData(fitData);

        }
    }

    private double correctCoordinate(double value) {
        return value / 11930465;
    }

    public void onClickBack(View view) {
        onBackPressed();
    }

    public String convertTime(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        return format.format(date);
    }
}