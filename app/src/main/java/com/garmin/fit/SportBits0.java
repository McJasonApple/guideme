////////////////////////////////////////////////////////////////////////////////
// The following FIT Protocol software provided may be used with FIT protocol
// devices only and remains the copyrighted property of Garmin Canada Inc.
// The software is being provided on an "as-is" basis and as an accommodation,
// and therefore all warranties, representations, or guarantees of any kind
// (whether express, implied or statutory) including, without limitation,
// warranties of merchantability, non-infringement, or fitness for a particular
// purpose, are specifically disclaimed.
//
// Copyright 2020 Garmin Canada Inc.
////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.40Release
// Tag = production/akw/21.40.00-0-g813c158
////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

public class SportBits0 {
    public static final short GENERIC = 0x01;
    public static final short RUNNING = 0x02;
    public static final short CYCLING = 0x04;
    public static final short TRANSITION = 0x08; // Mulitsport transition
    public static final short FITNESS_EQUIPMENT = 0x10;
    public static final short SWIMMING = 0x20;
    public static final short BASKETBALL = 0x40;
    public static final short SOCCER = 0x80;
    public static final short INVALID = Fit.UINT8Z_INVALID;

    private static final Map<Short, String> stringMap;

    static {
        stringMap = new HashMap<Short, String>();
        stringMap.put(GENERIC, "GENERIC");
        stringMap.put(RUNNING, "RUNNING");
        stringMap.put(CYCLING, "CYCLING");
        stringMap.put(TRANSITION, "TRANSITION");
        stringMap.put(FITNESS_EQUIPMENT, "FITNESS_EQUIPMENT");
        stringMap.put(SWIMMING, "SWIMMING");
        stringMap.put(BASKETBALL, "BASKETBALL");
        stringMap.put(SOCCER, "SOCCER");
    }


    /**
     * Retrieves the String Representation of the Value
     * @return The string representation of the value, or empty if unknown
     */
    public static String getStringFromValue( Short value ) {
        if( stringMap.containsKey( value ) ) {
            return stringMap.get( value );
        }

        return "";
    }

    /**
     * Retrieves a value given a string representation
     * @return The value or INVALID if unkwown
     */
    public static Short getValueFromString( String value ) {
        for( Map.Entry<Short, String> entry : stringMap.entrySet() ) {
            if( entry.getValue().equals( value ) ) {
                return entry.getKey();
            }
        }

        return INVALID;
    }

}
