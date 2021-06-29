package com.guideme;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.garmin.fit.Profile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.guideme.MapBox.MapBoxController;
import com.guideme.Model.Coordinate;
import com.guideme.Model.DatabaseController;
import com.guideme.Model.FitData;
import com.guideme.Model.FitRowData;
import com.guideme.Model.TrainingCalculator;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.PlaceAutocomplete;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;
    private MapView mapView;
    private MapboxMap mapboxMap;
    private MapBoxController mapBox;
    private FirebaseAuth firebaseAuth;
    private DatabaseController databaseController;
    private View legend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_map);
        requestLocationPermission();

        legend = findViewById(R.id.legend);
        firebaseAuth = FirebaseAuth.getInstance();
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        databaseController = DatabaseController.getInstance(firebaseAuth.getUid());
        String routeId = getIntent().getStringExtra("routeId");

        mapView.getMapAsync(mapboxMapMap -> {   //set Mapview
            mapboxMap = mapboxMapMap;
            mapboxMap.setStyle(Style.OUTDOORS, style -> {
                mapBox = new MapBoxController(mapboxMap, mapView, getApplicationContext());

                if (routeId != null && !routeId.equals("")) {  //shows route
                    displayRoute(routeId);
                }
            });
        });
    }

    //Requests Permission for the Location of the current Device
    private void requestLocationPermission() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case 1 :
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

    //display route with routeid
    private void displayRoute(String routeId) {
        legend.setVisibility(View.VISIBLE);
        ArrayList<FitData> fitDataList = databaseController.getFitData();

        for (FitData fitData : fitDataList) {
            if (fitData != null && fitData.getFitIdString().equals(routeId)) {  //select correct route
                fitData = TrainingCalculator.calcTraining(fitData, getApplicationContext());
                ArrayList<Point> points = new ArrayList<>();
                ArrayList<Integer> trainingsLevels = new ArrayList<>();
                Coordinate prev = new Coordinate();

                for (FitRowData fitRowData : fitData.getFitRow()) { //filter redundant points
                    if (!prev.equals(fitRowData.getCoordinate())) {
                        prev = fitRowData.getCoordinate();
                        Point point = fitRowData.getCoordinate().toPoint();
                        points.add(point);
                        trainingsLevels.add(fitRowData.getTrainingsLevel());
                    }
                }
                mapBox.createRoute(points, trainingsLevels);    //show route

                Point startPoint = points.get(0);
                mapBox.createMarker(mapboxMap, new LatLng(startPoint.latitude(), startPoint.longitude()));
                mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(  //zoom to start
                        new CameraPosition.Builder()
                                .target(new LatLng(startPoint.latitude(), startPoint.longitude()))
                                .zoom(14)
                                .build()), 4000);
                return;
            }
        }
        Toast.makeText(this, "Route not found.", Toast.LENGTH_SHORT).show();    //error if route not found
    }

    //Search Button
    public void onSearchClick(View view) {
        Intent intent = new PlaceAutocomplete.IntentBuilder()
                .accessToken(Mapbox.getAccessToken() != null ? Mapbox.getAccessToken() : getString(R.string.mapbox_access_token))
                .placeOptions(PlaceOptions.builder()
                        .backgroundColor(Color.parseColor("#EEEEEE"))
                        .limit(10)
                        .build(PlaceOptions.MODE_CARDS))
                .build(MapActivity.this);
        startActivityForResult(intent, REQUEST_CODE_AUTOCOMPLETE);
    }

    //Import Button
    public void onImportClick(View view) {
        startActivity(new Intent(this, ImportFileActivity.class));
    }

    //Route Button
    public void onMyRoutesClick(View view) {
        Intent intent = new Intent(this, MyRoutesActivity.class);
        intent.putExtra("userId", firebaseAuth.getCurrentUser().getUid());
        startActivity(intent);
    }

    //Profil Button
    public void onClickProfile (View view) {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    //Return User Location
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_AUTOCOMPLETE) {
            CarmenFeature selectedCarmenFeature = PlaceAutocomplete.getPlace(data);

            if (mapboxMap != null) {
                Style style = mapboxMap.getStyle();
                if (style != null) {
                    GeoJsonSource source = style.getSourceAs("geojsonSourceLayerId");
                    if (source != null) {
                        source.setGeoJson(FeatureCollection.fromFeatures(
                                new Feature[]{Feature.fromJson(selectedCarmenFeature.toJson())}));
                    }
                    mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(
                            new CameraPosition.Builder()
                                    .target(new LatLng(((Point) selectedCarmenFeature.geometry()).latitude(),
                                            ((Point) selectedCarmenFeature.geometry()).longitude()))
                                    .zoom(14)
                                    .build()), 4000);
                }
            }
            MapBoxController.createMarker(mapboxMap, new LatLng(((Point) selectedCarmenFeature.geometry()).latitude(),
                    ((Point) selectedCarmenFeature.geometry()).longitude()));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
        //firebaseAuth.signOut();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}