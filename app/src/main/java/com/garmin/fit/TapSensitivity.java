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


public enum TapSensitivity {
    HIGH((short)0),
    MEDIUM((short)1),
    LOW((short)2),
    INVALID((short)255);

    protected short value;

    private TapSensitivity(short value) {
        this.value = value;
    }

    public static TapSensitivity getByValue(final Short value) {
        for (final TapSensitivity type : TapSensitivity.values()) {
            if (value == type.value)
                return type;
        }

        return TapSensitivity.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @return The string representation of the value
     */
    public static String getStringFromValue( TapSensitivity value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
