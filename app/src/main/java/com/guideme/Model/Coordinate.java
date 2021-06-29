package com.guideme.Model;

import com.mapbox.geojson.Point;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class Coordinate {
    private double latitude;
    private double longitude;
    private double altitude;

    public Coordinate() {
        latitude = 0;
        longitude = 0;
        altitude = 0;
    }

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = 0;
    }

    public Coordinate(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public Point toPoint() {
        return Point.fromLngLat(longitude, latitude, altitude);
    }

    public boolean equals(Coordinate coordinate) {
        double latDiff = coordinate.latitude - this.latitude;
        double longDiff = coordinate.longitude - this.longitude;

        return abs(latDiff) < 0.00001 && abs(longDiff) < 0.00001;
    }
}
