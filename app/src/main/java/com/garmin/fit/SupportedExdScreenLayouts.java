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

public class SupportedExdScreenLayouts {
    public static final long FULL_SCREEN = 0x00000001;
    public static final long HALF_VERTICAL = 0x00000002;
    public static final long HALF_HORIZONTAL = 0x00000004;
    public static final long HALF_VERTICAL_RIGHT_SPLIT = 0x00000008;
    public static final long HALF_HORIZONTAL_BOTTOM_SPLIT = 0x00000010;
    public static final long FULL_QUARTER_SPLIT = 0x00000020;
    public static final long HALF_VERTICAL_LEFT_SPLIT = 0x00000040;
    public static final long HALF_HORIZONTAL_TOP_SPLIT = 0x00000080;
    public static final long INVALID = Fit.UINT32Z_INVALID;

    private static final Map<Long, String> stringMap;

    static {
        stringMap = new HashMap<Long, String>();
        stringMap.put(FULL_SCREEN, "FULL_SCREEN");
        stringMap.put(HALF_VERTICAL, "HALF_VERTICAL");
        stringMap.put(HALF_HORIZONTAL, "HALF_HORIZONTAL");
        stringMap.put(HALF_VERTICAL_RIGHT_SPLIT, "HALF_VERTICAL_RIGHT_SPLIT");
        stringMap.put(HALF_HORIZONTAL_BOTTOM_SPLIT, "HALF_HORIZONTAL_BOTTOM_SPLIT");
        stringMap.put(FULL_QUARTER_SPLIT, "FULL_QUARTER_SPLIT");
        stringMap.put(HALF_VERTICAL_LEFT_SPLIT, "HALF_VERTICAL_LEFT_SPLIT");
        stringMap.put(HALF_HORIZONTAL_TOP_SPLIT, "HALF_HORIZONTAL_TOP_SPLIT");
    }


    /**
     * Retrieves the String Representation of the Value
     * @return The string representation of the value, or empty if unknown
     */
    public static String getStringFromValue( Long value ) {
        if( stringMap.containsKey( value ) ) {
            return stringMap.get( value );
        }

        return "";
    }

    /**
     * Retrieves a value given a string representation
     * @return The value or INVALID if unkwown
     */
    public static Long getValueFromString( String value ) {
        for( Map.Entry<Long, String> entry : stringMap.entrySet() ) {
            if( entry.getValue().equals( value ) ) {
                return entry.getKey();
            }
        }

        return INVALID;
    }

}
