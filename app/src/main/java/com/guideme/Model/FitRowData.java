package com.guideme.Model;

import java.util.Date;
import java.util.Objects;

public class FitRowData implements Comparable{
    public long timestamp;
    public Coordinate coordinate;
    public Double distance;
    public Double currentSpeed;
    public Integer currentPower;
    public Integer currentTemperature;
    public Double currentCadence;
    public Integer trainingsLevel;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        //Convert to Real Date from Garmin time to Java Time
        GarminConverter gc = new GarminConverter();
        Date ConvertedDate;
        ConvertedDate = gc.normalizeFitDate(timestamp);
        this.timestamp = ConvertedDate.getTime();
    }

    public Integer getTrainingsLevel() {
        return trainingsLevel;
    }

    public void setTrainingsLevel(Integer trainingsLevel) {
        this.trainingsLevel = trainingsLevel;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double latitude, double longitude, double altitude) {
        Coordinate coordinate = new Coordinate(latitude, longitude, altitude);
        this.coordinate = coordinate;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(Double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Integer getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(Integer currentPower) {
        this.currentPower = currentPower;
    }

    public Integer getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Integer currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getCurrentCadence() {
        return currentCadence;
    }

    public void setCurrentCadence(Double currentCadence) {
        this.currentCadence = currentCadence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FitRowData that = (FitRowData) o;
        return timestamp == that.timestamp &&
                Objects.equals(coordinate, that.coordinate) &&
                Objects.equals(distance, that.distance) &&
                Objects.equals(currentSpeed, that.currentSpeed) &&
                Objects.equals(currentPower, that.currentPower) &&
                Objects.equals(currentTemperature, that.currentTemperature) &&
                Objects.equals(currentCadence, that.currentCadence) &&
                Objects.equals(trainingsLevel, that.trainingsLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, coordinate, distance, currentSpeed, currentPower, currentTemperature, currentCadence, trainingsLevel);
    }

    @Override
    public int compareTo(Object o) {
        long compareTime = ((FitRowData)o).getTimestamp();
        return (int) (this.timestamp-compareTime);
    }
}
