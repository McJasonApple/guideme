package com.guideme.MapBox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineCallback;
import com.mapbox.android.core.location.LocationEngineProvider;
import com.mapbox.android.core.location.LocationEngineRequest;
import com.mapbox.android.core.location.LocationEngineResult;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;

public class MapBoxLocation {
    private static final long DEFAULT_INTERVAL_IN_MILLISECONDS = 1000L;
    private static final long DEFAULT_MAX_WAIT_TIME = DEFAULT_INTERVAL_IN_MILLISECONDS * 5;
    private MapboxMap mapboxMap;
    private MapView mapView;
    private LocationEngine locationEngine;
    private LocationChangeCallback callback;
    private Context context;

    public MapBoxLocation(MapboxMap mapboxMap, MapView mapView, Context context) {
        this.mapboxMap = mapboxMap;
        this.mapView = mapView;
        this.context = context;
        this.callback = new LocationChangeCallback(context, mapboxMap);
        enableLocationComponent(mapboxMap.getStyle());
    }

    @SuppressWarnings({"MissingPermission"})
    private void enableLocationComponent(@NonNull Style loadedMapStyle) {
        if (PermissionsManager.areLocationPermissionsGranted(context)) {
            LocationComponent locationComponent = mapboxMap.getLocationComponent();
            LocationComponentActivationOptions locationComponentActivationOptions =
                    LocationComponentActivationOptions.builder(context, loadedMapStyle)
                            .useDefaultLocationEngine(false)
                            .build();
            locationComponent.activateLocationComponent(locationComponentActivationOptions);
            locationComponent.setLocationComponentEnabled(true);
            locationComponent.setCameraMode(CameraMode.TRACKING);
            locationComponent.setRenderMode(RenderMode.COMPASS);
            locationComponent.zoomWhileTracking(12);
            initLocationEngine();
        }
    }

    @SuppressLint("MissingPermission")
    private void initLocationEngine() {
        locationEngine = LocationEngineProvider.getBestLocationEngine(context);
        LocationEngineRequest request = new LocationEngineRequest.Builder(DEFAULT_INTERVAL_IN_MILLISECONDS)
                .setPriority(LocationEngineRequest.PRIORITY_HIGH_ACCURACY)
                .setMaxWaitTime(DEFAULT_MAX_WAIT_TIME).build();
        locationEngine.requestLocationUpdates(request, callback, context.getMainLooper());
        locationEngine.getLastLocation(callback);
    }

    private static class LocationChangeCallback implements LocationEngineCallback<LocationEngineResult> {
        private final Context context;
        private final MapboxMap mapboxMap;

        LocationChangeCallback(Context context, MapboxMap mapboxMap) {
            this.context = context;
            this.mapboxMap = mapboxMap;
        }

        /**
         * The LocationEngineCallback interface's method which fires when the device's location has changed.
         * @param result the LocationEngineResult object which has the last known location within it.
         */
        @Override
        public void onSuccess(LocationEngineResult result) {
            Location location = result.getLastLocation();

            if (location == null) return;

            if (mapboxMap != null && result.getLastLocation() != null) {
                mapboxMap.getLocationComponent().forceLocationUpdate(result.getLastLocation());
            }
        }

        //The LocationEngineCallback interface's method which fires when the device's location can't be captured
        @Override
        public void onFailure(@NonNull Exception exception) {
            Toast.makeText(context, "GPS not Found", Toast.LENGTH_SHORT).show();
            Log.e("Location Error: ", exception.toString());
        }
    }
}
