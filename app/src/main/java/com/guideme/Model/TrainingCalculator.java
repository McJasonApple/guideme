package com.guideme.Model;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.core.content.ContextCompat;

import com.garmin.fit.Fit;
import com.google.firebase.auth.FirebaseAuth;
import com.guideme.R;

import java.util.ArrayList;
import java.util.Collections;

public class TrainingCalculator {
    static double ftp;

    public static FitData calcTraining(FitData fitData, Context context) {
        //create averaged FitData object
        FitData training = average(30, fitData);
        //get traininglevel of every FitRowData entry
        training = getTrainingLevel(training, context);
        return training;
    }

    //get personal ftp of the current user
    private static void getFtp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.guideme", Context.MODE_PRIVATE);
        ftp = sharedPreferences.getFloat("ftp", 210);
    }

    //average every value over a specified interval
    private static FitData average(int interval, FitData fitData) {
        ArrayList<Double> powerData = new ArrayList<>();
        for (int i = 0; i < fitData.getFitRow().size(); i++) {
            int sum = 0;
            for (int j = i; j < i + interval; j++) {
                if (fitData.getFitRow().size() > j) {
                    sum += fitData.getFitRow().get(j).getCurrentPower();
                } else {
                    break;
                }
            }
            fitData.getFitRow().get(i).setCurrentPower(sum / interval);
            powerData.add((double) (sum / interval));
        }
        return fitData;
    }

    //calcs trainignslevel based on current Powerlevel
    private static FitData getTrainingLevel(FitData fitData, Context context) {
        getFtp(context);

        for (FitRowData fitRowData : fitData.getFitRow()) {
            double power = fitRowData.getCurrentPower();

            //traininglevel is calculated relative to the personal ftp
            if (power <= ftp * 0.55) fitRowData.setTrainingsLevel(1);
            else if (power <= ftp * 0.77 && power > ftp * 0.55) fitRowData.setTrainingsLevel(2);
            else if (power <= ftp * 0.90 && power > ftp * 0.77) fitRowData.setTrainingsLevel(3);
            else if (power <= ftp * 1.05 && power > ftp * 0.90) fitRowData.setTrainingsLevel(4);
            else if (power <= ftp * 1.20 && power > ftp * 1.05) fitRowData.setTrainingsLevel(5);
            else if (power <= ftp * 1.50 && power > ftp * 1.20) fitRowData.setTrainingsLevel(6);
            else fitRowData.setTrainingsLevel(7);
        }
        return fitData;
    }

    //creates an arraylist that shows the distribution of every traininglevel on the route
    public static ArrayList<Integer> getLevelDistribution(FitData fitData, Context context) {
        ArrayList<Integer> levelDistribution = new ArrayList<Integer>(Collections.nCopies(6, 0));

        for (FitRowData fitRowData : fitData.getFitRow()) {

            if(fitRowData.getTrainingsLevel() == null) {
                fitData = TrainingCalculator.calcTraining(fitData, context);
            }

            switch (fitRowData.getTrainingsLevel()) {
                case 1: levelDistribution.set(0, levelDistribution.get(0)+1); break;
                case 2: levelDistribution.set(1, levelDistribution.get(1)+1); break;
                case 3: levelDistribution.set(1, levelDistribution.get(1)+1); break;
                case 4: levelDistribution.set(2, levelDistribution.get(2)+1); break;
                case 5: levelDistribution.set(3, levelDistribution.get(3)+1); break;
                case 6: levelDistribution.set(4, levelDistribution.get(4)+1); break;
                default: levelDistribution.set(5, levelDistribution.get(5)+1); break;
            }
        }
        return levelDistribution;
    }

    public static String detectTraining(FitData fitData, Context context) {
        String result = "";


       // Collections.sort(fitData.getFitRow());
        //chech which of trainingprogramms can be found in the data
        if(v02maxTraining(fitData, context)) result += "6x4'5\n";
        if(intervalAnerob(fitData, context)) result += "10x(30\"6+30\"1)\n";
        if(laktatVo2Training(fitData, context)) result += "2x(6x(1'4+1'5)5'erh.)\n";
        if(laktatTraining(fitData, context)) result += "2x20'4";

        if(result.equals("")) result = "No training detected";

        return result;
    }

    //Training for 6x4'5
    private static boolean v02maxTraining(FitData fitData, Context context) {
        if(fitData.getLevelDistribution(context).get(3) >= 1440) { //check if possible (6*4min = 1440sec)
            int index = 0;
            for (int i = 0; i<6; i++) { //check 240sec level 5 interval 6 times
                Object[] returnValues = checkInterval(fitData.getFitRow(), index, 240, 5);
                if((boolean) returnValues[0] == false) return false; //no valid interval found
                index = (int) returnValues[1];
            }
        } else {
            return false;
        }

        return true;
    }

    //Training for 10x(30"6+30"1)
    private static boolean intervalAnerob(FitData fitData, Context context) {    //same concept as in v02maxTraining()
        if(fitData.getLevelDistribution(context).get(4) >= 180) {
            int index = 0;
            for (int i = 0; i<11; i++) {
                Object[] returnValues = checkInterval(fitData.getFitRow(), index, 30, 6);
                if(!(boolean) returnValues[0]) return false;
                index = (int) returnValues[1];

                returnValues = checkInterval(fitData.getFitRow(), index, 30, 1);
                if(!(boolean) returnValues[0]) return false;
                index = (int) returnValues[1];
            }
        } else {
            return false;
        }
        return true;
    }

    //Training for 2x(6x(1'4+1'5)5'erh.) erh. = level1?
    private static boolean laktatVo2Training(FitData fitData, Context context) {
        if(fitData.getLevelDistribution(context).get(2) >= 720 && fitData.getLevelDistribution(context).get(3) >= 720) {
            int index = 0;
            for (int i = 0; i<3; i++) {
                Object[] returnValues;
                for (int j = 0; j<7; j++) {
                    returnValues = checkInterval(fitData.getFitRow(), index, 60, 4);
                    if(!(boolean) returnValues[0]) return false;
                    index = (int) returnValues[1];

                    returnValues = checkInterval(fitData.getFitRow(), index, 60, 5);
                    if(!(boolean) returnValues[0]) return false;
                    index = (int) returnValues[1];
                }
                returnValues = checkInterval(fitData.getFitRow(), index, 300, 1);
                if(!(boolean) returnValues[0]) return false;
                index = (int) returnValues[1];
            }
        }else {
            return false;
        }
        return true;
    }

    //Training for 2x20'4
    private static boolean laktatTraining(FitData fitData, Context context) {
        if(fitData.getLevelDistribution(context).get(4) >= 2400) { //check if possible (2*20min = 2400sec)
            int index = 0;
            for (int i = 0; i<2; i++) { //check 1200sec interval 2 times
                Object[] returnValues = checkInterval(fitData.getFitRow(), index, 1200, 4);
                if(!(boolean) returnValues[0]) return false;
                index = (int) returnValues[1];
            }
        }else {
            return false;
        }

        return true;
    }

    //checks if the passed data has an intervall that is above the minimum traininglevel
    private static Object[] checkInterval (ArrayList<FitRowData> fitRowData, int index, int intervalLength, int intervalLevel) {
        boolean validInterval = false;
        int levelCount = 0;
        int failcounter =0;
        int failcounter_max = intervalLength/3;

        while (index < fitRowData.size()) {
            int level = fitRowData.get(index).getTrainingsLevel();
            index++;

            if(level >= intervalLevel && level <= intervalLevel+2) { // two level upwards tolerance
                if(levelCount == 0){
                    failcounter = 0;
                }
                levelCount++;

                if(levelCount == intervalLength) {  //correct level as many times as intervalLength
                    validInterval = true;
                    break;
                }
            } else {    //resets counter if level is below the requested
                if (failcounter <=failcounter_max){
                    failcounter++;
                }
                else {
                    levelCount = 0;
                    failcounter =0;
                }
            }
        }

        return new Object[]{validInterval, index};  //multiple return types
    }
}

