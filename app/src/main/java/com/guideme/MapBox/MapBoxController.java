package com.guideme.MapBox;

import android.content.Context;

import androidx.annotation.NonNull;

import com.guideme.Model.FitData;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;

import java.util.ArrayList;

public class MapBoxController {
    private MapboxMap mapboxMap;
    private MapView mapView;
    private Context context;
    private MapBoxRoute mapBoxRoute;
    private boolean route_active = false;

    public MapBoxController(MapboxMap mapboxMap, MapView mapView, Context context) {
        this.mapboxMap = mapboxMap;
        this.context = context;
        onCreateMarker();
        if (PermissionsManager.areLocationPermissionsGranted(context)) {
            new MapBoxLocation(mapboxMap, mapView, context);
        }
        mapBoxRoute = new MapBoxRoute(mapboxMap, context);
    }

    //provisorisch
    private void onCreateMarker() { //Creates marker onClick
        mapboxMap.addOnMapClickListener(new MapboxMap.OnMapClickListener() {
            @Override
            public boolean onMapClick(@NonNull LatLng point) {
                mapboxMap.addMarker(new MarkerOptions().position(point));   //deprecated but works, new version is to complicated
                return true;
            }
        });
    }

    //create marker at position
    public static void createMarker(MapboxMap mapboxMap, LatLng point) {
        mapboxMap.addMarker(new MarkerOptions().position(point));
    }

    //create route
    public void createRoute(ArrayList<Point> points, ArrayList<Integer> trainingsLevels) {
        mapBoxRoute.addRoute(points, trainingsLevels);
    }
}
