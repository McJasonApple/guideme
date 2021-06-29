package com.guideme.Model;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class GarminConverter {


    public Date normalizeFitDate(long seconds){
        //convert Garmin time to Java Time
        Calendar beginning = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        beginning.set(1989,12,31,12,0);
        long secondsSinceUnix = beginning.getTimeInMillis() /1000L;
        long correctedSecondsSinceGarmin = secondsSinceUnix + seconds;
        Date correctedTime = new Date((long)correctedSecondsSinceGarmin*1000);
        return correctedTime;
    }
}
