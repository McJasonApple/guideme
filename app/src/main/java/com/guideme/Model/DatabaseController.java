package com.guideme.Model;

import android.widget.Toast;

import androidx.annotation.NonNull;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DatabaseController {

    private static DatabaseController databaseController;
    private FirebaseDatabase database;
    private String userId;
    private ArrayList<FitData> fitData;

    private DatabaseController(String userId){
        this.userId = userId;
        this.database = FirebaseDatabase.getInstance();
        this.fitData = new ArrayList<>();
        FitDataListener();
    }

    //listen for Database changes
    private void FitDataListener() {
        database.getReference("FitData").child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                fitData = new ArrayList<>();
                for (DataSnapshot element : snapshot.getChildren()) {
                    fitData.add(element.getValue(FitData.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public ArrayList<FitData> getFitData() {
        return fitData;
    }

    //create/get an instance of the database controller to operate with firebase
    public static DatabaseController getInstance(String userId) {
        if(databaseController == null) {
            databaseController = new DatabaseController(userId);
        }
        return databaseController;
    }

    //write fitdata to firebase
    public void addFitData(FitData fitData) {
        String uid = fitData.getUserId();
        String fid = fitData.getFitIdString();
        database.getReference("FitData").child(uid).child(fid).setValue(fitData);
    }

    //update fitdata in firebase
    public void updateFitData(FitData fitData) {
        database.getReference("FitData").child(fitData.getUserId()).child(fitData.getFitIdString()).setValue(fitData);
    }

    //delete a set of data from firebase
    public void delete(String path){
        database.getReference(path).removeValue();
    }
}
