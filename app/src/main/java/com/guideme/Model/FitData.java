package com.guideme.Model;


import android.content.Context;
import android.util.Log;

import com.garmin.fit.Fit;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class FitData {
    private String fitIdString;
    private String userId;
    private String routeName;
    private String training;
    private ArrayList<Integer> levelDistribution;
    public ArrayList<FitRowData> fitRow;

    public FitData() {

    }

    public FitData(String userId, ArrayList<FitRowData> fitRows, String name) {

        this.userId = userId;
        this.fitRow = fitRows;
        this.fitIdString = UUID.randomUUID().toString();
        this.routeName = name;
    }

    public String getRouteName() {
        if(routeName == null) routeName = fitIdString;

        return routeName;
    }

    //calc leveldistribution of all seven levels
    //only calculate new if there is no distribution
    public ArrayList<Integer> getLevelDistribution(Context context) {
        if(levelDistribution == null) {
            levelDistribution = TrainingCalculator.getLevelDistribution(this, context);
            DatabaseController.getInstance(userId).updateFitData(this);
        }
        return levelDistribution;
    }

    //calc Training if no training was calculated before
    public String getTraining(Context context) {
        if(training == null) {
            training = TrainingCalculator.detectTraining(this, context);
            DatabaseController.getInstance(userId).updateFitData(this);
        }
        return training;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getFitIdString() {
        return fitIdString;
    }

    public void setFitRows(ArrayList<FitRowData> fitRows) {
        fitRow = fitRows;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<FitRowData> getFitRow() {
        return fitRow;
    }

    public double getDistance() {
        return fitRow.get(fitRow.size()-1).getDistance();
    }

}
