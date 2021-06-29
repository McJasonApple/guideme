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

public class CoreExerciseName {
    public static final int ABS_JABS = 0;
    public static final int WEIGHTED_ABS_JABS = 1;
    public static final int ALTERNATING_PLATE_REACH = 2;
    public static final int BARBELL_ROLLOUT = 3;
    public static final int WEIGHTED_BARBELL_ROLLOUT = 4;
    public static final int BODY_BAR_OBLIQUE_TWIST = 5;
    public static final int CABLE_CORE_PRESS = 6;
    public static final int CABLE_SIDE_BEND = 7;
    public static final int SIDE_BEND = 8;
    public static final int WEIGHTED_SIDE_BEND = 9;
    public static final int CRESCENT_CIRCLE = 10;
    public static final int WEIGHTED_CRESCENT_CIRCLE = 11;
    public static final int CYCLING_RUSSIAN_TWIST = 12;
    public static final int WEIGHTED_CYCLING_RUSSIAN_TWIST = 13;
    public static final int ELEVATED_FEET_RUSSIAN_TWIST = 14;
    public static final int WEIGHTED_ELEVATED_FEET_RUSSIAN_TWIST = 15;
    public static final int HALF_TURKISH_GET_UP = 16;
    public static final int KETTLEBELL_WINDMILL = 17;
    public static final int KNEELING_AB_WHEEL = 18;
    public static final int WEIGHTED_KNEELING_AB_WHEEL = 19;
    public static final int MODIFIED_FRONT_LEVER = 20;
    public static final int OPEN_KNEE_TUCKS = 21;
    public static final int WEIGHTED_OPEN_KNEE_TUCKS = 22;
    public static final int SIDE_ABS_LEG_LIFT = 23;
    public static final int WEIGHTED_SIDE_ABS_LEG_LIFT = 24;
    public static final int SWISS_BALL_JACKKNIFE = 25;
    public static final int WEIGHTED_SWISS_BALL_JACKKNIFE = 26;
    public static final int SWISS_BALL_PIKE = 27;
    public static final int WEIGHTED_SWISS_BALL_PIKE = 28;
    public static final int SWISS_BALL_ROLLOUT = 29;
    public static final int WEIGHTED_SWISS_BALL_ROLLOUT = 30;
    public static final int TRIANGLE_HIP_PRESS = 31;
    public static final int WEIGHTED_TRIANGLE_HIP_PRESS = 32;
    public static final int TRX_SUSPENDED_JACKKNIFE = 33;
    public static final int WEIGHTED_TRX_SUSPENDED_JACKKNIFE = 34;
    public static final int U_BOAT = 35;
    public static final int WEIGHTED_U_BOAT = 36;
    public static final int WINDMILL_SWITCHES = 37;
    public static final int WEIGHTED_WINDMILL_SWITCHES = 38;
    public static final int ALTERNATING_SLIDE_OUT = 39;
    public static final int WEIGHTED_ALTERNATING_SLIDE_OUT = 40;
    public static final int GHD_BACK_EXTENSIONS = 41;
    public static final int WEIGHTED_GHD_BACK_EXTENSIONS = 42;
    public static final int OVERHEAD_WALK = 43;
    public static final int INCHWORM = 44;
    public static final int WEIGHTED_MODIFIED_FRONT_LEVER = 45;
    public static final int RUSSIAN_TWIST = 46;
    public static final int ABDOMINAL_LEG_ROTATIONS = 47; // Deprecated do not use
    public static final int ARM_AND_LEG_EXTENSION_ON_KNEES = 48;
    public static final int BICYCLE = 49;
    public static final int BICEP_CURL_WITH_LEG_EXTENSION = 50;
    public static final int CAT_COW = 51;
    public static final int CORKSCREW = 52;
    public static final int CRISS_CROSS = 53;
    public static final int CRISS_CROSS_WITH_BALL = 54; // Deprecated do not use
    public static final int DOUBLE_LEG_STRETCH = 55;
    public static final int KNEE_FOLDS = 56;
    public static final int LOWER_LIFT = 57;
    public static final int NECK_PULL = 58;
    public static final int PELVIC_CLOCKS = 59;
    public static final int ROLL_OVER = 60;
    public static final int ROLL_UP = 61;
    public static final int ROLLING = 62;
    public static final int ROWING_1 = 63;
    public static final int ROWING_2 = 64;
    public static final int SCISSORS = 65;
    public static final int SINGLE_LEG_CIRCLES = 66;
    public static final int SINGLE_LEG_STRETCH = 67;
    public static final int SNAKE_TWIST_1_AND_2 = 68; // Deprecated do not use
    public static final int SWAN = 69;
    public static final int SWIMMING = 70;
    public static final int TEASER = 71;
    public static final int THE_HUNDRED = 72;
    public static final int INVALID = Fit.UINT16_INVALID;

    private static final Map<Integer, String> stringMap;

    static {
        stringMap = new HashMap<Integer, String>();
        stringMap.put(ABS_JABS, "ABS_JABS");
        stringMap.put(WEIGHTED_ABS_JABS, "WEIGHTED_ABS_JABS");
        stringMap.put(ALTERNATING_PLATE_REACH, "ALTERNATING_PLATE_REACH");
        stringMap.put(BARBELL_ROLLOUT, "BARBELL_ROLLOUT");
        stringMap.put(WEIGHTED_BARBELL_ROLLOUT, "WEIGHTED_BARBELL_ROLLOUT");
        stringMap.put(BODY_BAR_OBLIQUE_TWIST, "BODY_BAR_OBLIQUE_TWIST");
        stringMap.put(CABLE_CORE_PRESS, "CABLE_CORE_PRESS");
        stringMap.put(CABLE_SIDE_BEND, "CABLE_SIDE_BEND");
        stringMap.put(SIDE_BEND, "SIDE_BEND");
        stringMap.put(WEIGHTED_SIDE_BEND, "WEIGHTED_SIDE_BEND");
        stringMap.put(CRESCENT_CIRCLE, "CRESCENT_CIRCLE");
        stringMap.put(WEIGHTED_CRESCENT_CIRCLE, "WEIGHTED_CRESCENT_CIRCLE");
        stringMap.put(CYCLING_RUSSIAN_TWIST, "CYCLING_RUSSIAN_TWIST");
        stringMap.put(WEIGHTED_CYCLING_RUSSIAN_TWIST, "WEIGHTED_CYCLING_RUSSIAN_TWIST");
        stringMap.put(ELEVATED_FEET_RUSSIAN_TWIST, "ELEVATED_FEET_RUSSIAN_TWIST");
        stringMap.put(WEIGHTED_ELEVATED_FEET_RUSSIAN_TWIST, "WEIGHTED_ELEVATED_FEET_RUSSIAN_TWIST");
        stringMap.put(HALF_TURKISH_GET_UP, "HALF_TURKISH_GET_UP");
        stringMap.put(KETTLEBELL_WINDMILL, "KETTLEBELL_WINDMILL");
        stringMap.put(KNEELING_AB_WHEEL, "KNEELING_AB_WHEEL");
        stringMap.put(WEIGHTED_KNEELING_AB_WHEEL, "WEIGHTED_KNEELING_AB_WHEEL");
        stringMap.put(MODIFIED_FRONT_LEVER, "MODIFIED_FRONT_LEVER");
        stringMap.put(OPEN_KNEE_TUCKS, "OPEN_KNEE_TUCKS");
        stringMap.put(WEIGHTED_OPEN_KNEE_TUCKS, "WEIGHTED_OPEN_KNEE_TUCKS");
        stringMap.put(SIDE_ABS_LEG_LIFT, "SIDE_ABS_LEG_LIFT");
        stringMap.put(WEIGHTED_SIDE_ABS_LEG_LIFT, "WEIGHTED_SIDE_ABS_LEG_LIFT");
        stringMap.put(SWISS_BALL_JACKKNIFE, "SWISS_BALL_JACKKNIFE");
        stringMap.put(WEIGHTED_SWISS_BALL_JACKKNIFE, "WEIGHTED_SWISS_BALL_JACKKNIFE");
        stringMap.put(SWISS_BALL_PIKE, "SWISS_BALL_PIKE");
        stringMap.put(WEIGHTED_SWISS_BALL_PIKE, "WEIGHTED_SWISS_BALL_PIKE");
        stringMap.put(SWISS_BALL_ROLLOUT, "SWISS_BALL_ROLLOUT");
        stringMap.put(WEIGHTED_SWISS_BALL_ROLLOUT, "WEIGHTED_SWISS_BALL_ROLLOUT");
        stringMap.put(TRIANGLE_HIP_PRESS, "TRIANGLE_HIP_PRESS");
        stringMap.put(WEIGHTED_TRIANGLE_HIP_PRESS, "WEIGHTED_TRIANGLE_HIP_PRESS");
        stringMap.put(TRX_SUSPENDED_JACKKNIFE, "TRX_SUSPENDED_JACKKNIFE");
        stringMap.put(WEIGHTED_TRX_SUSPENDED_JACKKNIFE, "WEIGHTED_TRX_SUSPENDED_JACKKNIFE");
        stringMap.put(U_BOAT, "U_BOAT");
        stringMap.put(WEIGHTED_U_BOAT, "WEIGHTED_U_BOAT");
        stringMap.put(WINDMILL_SWITCHES, "WINDMILL_SWITCHES");
        stringMap.put(WEIGHTED_WINDMILL_SWITCHES, "WEIGHTED_WINDMILL_SWITCHES");
        stringMap.put(ALTERNATING_SLIDE_OUT, "ALTERNATING_SLIDE_OUT");
        stringMap.put(WEIGHTED_ALTERNATING_SLIDE_OUT, "WEIGHTED_ALTERNATING_SLIDE_OUT");
        stringMap.put(GHD_BACK_EXTENSIONS, "GHD_BACK_EXTENSIONS");
        stringMap.put(WEIGHTED_GHD_BACK_EXTENSIONS, "WEIGHTED_GHD_BACK_EXTENSIONS");
        stringMap.put(OVERHEAD_WALK, "OVERHEAD_WALK");
        stringMap.put(INCHWORM, "INCHWORM");
        stringMap.put(WEIGHTED_MODIFIED_FRONT_LEVER, "WEIGHTED_MODIFIED_FRONT_LEVER");
        stringMap.put(RUSSIAN_TWIST, "RUSSIAN_TWIST");
        stringMap.put(ABDOMINAL_LEG_ROTATIONS, "ABDOMINAL_LEG_ROTATIONS");
        stringMap.put(ARM_AND_LEG_EXTENSION_ON_KNEES, "ARM_AND_LEG_EXTENSION_ON_KNEES");
        stringMap.put(BICYCLE, "BICYCLE");
        stringMap.put(BICEP_CURL_WITH_LEG_EXTENSION, "BICEP_CURL_WITH_LEG_EXTENSION");
        stringMap.put(CAT_COW, "CAT_COW");
        stringMap.put(CORKSCREW, "CORKSCREW");
        stringMap.put(CRISS_CROSS, "CRISS_CROSS");
        stringMap.put(CRISS_CROSS_WITH_BALL, "CRISS_CROSS_WITH_BALL");
        stringMap.put(DOUBLE_LEG_STRETCH, "DOUBLE_LEG_STRETCH");
        stringMap.put(KNEE_FOLDS, "KNEE_FOLDS");
        stringMap.put(LOWER_LIFT, "LOWER_LIFT");
        stringMap.put(NECK_PULL, "NECK_PULL");
        stringMap.put(PELVIC_CLOCKS, "PELVIC_CLOCKS");
        stringMap.put(ROLL_OVER, "ROLL_OVER");
        stringMap.put(ROLL_UP, "ROLL_UP");
        stringMap.put(ROLLING, "ROLLING");
        stringMap.put(ROWING_1, "ROWING_1");
        stringMap.put(ROWING_2, "ROWING_2");
        stringMap.put(SCISSORS, "SCISSORS");
        stringMap.put(SINGLE_LEG_CIRCLES, "SINGLE_LEG_CIRCLES");
        stringMap.put(SINGLE_LEG_STRETCH, "SINGLE_LEG_STRETCH");
        stringMap.put(SNAKE_TWIST_1_AND_2, "SNAKE_TWIST_1_AND_2");
        stringMap.put(SWAN, "SWAN");
        stringMap.put(SWIMMING, "SWIMMING");
        stringMap.put(TEASER, "TEASER");
        stringMap.put(THE_HUNDRED, "THE_HUNDRED");
    }


    /**
     * Retrieves the String Representation of the Value
     * @return The string representation of the value, or empty if unknown
     */
    public static String getStringFromValue( Integer value ) {
        if( stringMap.containsKey( value ) ) {
            return stringMap.get( value );
        }

        return "";
    }

    /**
     * Retrieves a value given a string representation
     * @return The value or INVALID if unkwown
     */
    public static Integer getValueFromString( String value ) {
        for( Map.Entry<Integer, String> entry : stringMap.entrySet() ) {
            if( entry.getValue().equals( value ) ) {
                return entry.getKey();
            }
        }

        return INVALID;
    }

}
