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

public class CrunchExerciseName {
    public static final int BICYCLE_CRUNCH = 0;
    public static final int CABLE_CRUNCH = 1;
    public static final int CIRCULAR_ARM_CRUNCH = 2;
    public static final int CROSSED_ARMS_CRUNCH = 3;
    public static final int WEIGHTED_CROSSED_ARMS_CRUNCH = 4;
    public static final int CROSS_LEG_REVERSE_CRUNCH = 5;
    public static final int WEIGHTED_CROSS_LEG_REVERSE_CRUNCH = 6;
    public static final int CRUNCH_CHOP = 7;
    public static final int WEIGHTED_CRUNCH_CHOP = 8;
    public static final int DOUBLE_CRUNCH = 9;
    public static final int WEIGHTED_DOUBLE_CRUNCH = 10;
    public static final int ELBOW_TO_KNEE_CRUNCH = 11;
    public static final int WEIGHTED_ELBOW_TO_KNEE_CRUNCH = 12;
    public static final int FLUTTER_KICKS = 13;
    public static final int WEIGHTED_FLUTTER_KICKS = 14;
    public static final int FOAM_ROLLER_REVERSE_CRUNCH_ON_BENCH = 15;
    public static final int WEIGHTED_FOAM_ROLLER_REVERSE_CRUNCH_ON_BENCH = 16;
    public static final int FOAM_ROLLER_REVERSE_CRUNCH_WITH_DUMBBELL = 17;
    public static final int FOAM_ROLLER_REVERSE_CRUNCH_WITH_MEDICINE_BALL = 18;
    public static final int FROG_PRESS = 19;
    public static final int HANGING_KNEE_RAISE_OBLIQUE_CRUNCH = 20;
    public static final int WEIGHTED_HANGING_KNEE_RAISE_OBLIQUE_CRUNCH = 21;
    public static final int HIP_CROSSOVER = 22;
    public static final int WEIGHTED_HIP_CROSSOVER = 23;
    public static final int HOLLOW_ROCK = 24;
    public static final int WEIGHTED_HOLLOW_ROCK = 25;
    public static final int INCLINE_REVERSE_CRUNCH = 26;
    public static final int WEIGHTED_INCLINE_REVERSE_CRUNCH = 27;
    public static final int KNEELING_CABLE_CRUNCH = 28;
    public static final int KNEELING_CROSS_CRUNCH = 29;
    public static final int WEIGHTED_KNEELING_CROSS_CRUNCH = 30;
    public static final int KNEELING_OBLIQUE_CABLE_CRUNCH = 31;
    public static final int KNEES_TO_ELBOW = 32;
    public static final int LEG_EXTENSIONS = 33;
    public static final int WEIGHTED_LEG_EXTENSIONS = 34;
    public static final int LEG_LEVERS = 35;
    public static final int MCGILL_CURL_UP = 36;
    public static final int WEIGHTED_MCGILL_CURL_UP = 37;
    public static final int MODIFIED_PILATES_ROLL_UP_WITH_BALL = 38;
    public static final int WEIGHTED_MODIFIED_PILATES_ROLL_UP_WITH_BALL = 39;
    public static final int PILATES_CRUNCH = 40;
    public static final int WEIGHTED_PILATES_CRUNCH = 41;
    public static final int PILATES_ROLL_UP_WITH_BALL = 42;
    public static final int WEIGHTED_PILATES_ROLL_UP_WITH_BALL = 43;
    public static final int RAISED_LEGS_CRUNCH = 44;
    public static final int WEIGHTED_RAISED_LEGS_CRUNCH = 45;
    public static final int REVERSE_CRUNCH = 46;
    public static final int WEIGHTED_REVERSE_CRUNCH = 47;
    public static final int REVERSE_CRUNCH_ON_A_BENCH = 48;
    public static final int WEIGHTED_REVERSE_CRUNCH_ON_A_BENCH = 49;
    public static final int REVERSE_CURL_AND_LIFT = 50;
    public static final int WEIGHTED_REVERSE_CURL_AND_LIFT = 51;
    public static final int ROTATIONAL_LIFT = 52;
    public static final int WEIGHTED_ROTATIONAL_LIFT = 53;
    public static final int SEATED_ALTERNATING_REVERSE_CRUNCH = 54;
    public static final int WEIGHTED_SEATED_ALTERNATING_REVERSE_CRUNCH = 55;
    public static final int SEATED_LEG_U = 56;
    public static final int WEIGHTED_SEATED_LEG_U = 57;
    public static final int SIDE_TO_SIDE_CRUNCH_AND_WEAVE = 58;
    public static final int WEIGHTED_SIDE_TO_SIDE_CRUNCH_AND_WEAVE = 59;
    public static final int SINGLE_LEG_REVERSE_CRUNCH = 60;
    public static final int WEIGHTED_SINGLE_LEG_REVERSE_CRUNCH = 61;
    public static final int SKATER_CRUNCH_CROSS = 62;
    public static final int WEIGHTED_SKATER_CRUNCH_CROSS = 63;
    public static final int STANDING_CABLE_CRUNCH = 64;
    public static final int STANDING_SIDE_CRUNCH = 65;
    public static final int STEP_CLIMB = 66;
    public static final int WEIGHTED_STEP_CLIMB = 67;
    public static final int SWISS_BALL_CRUNCH = 68;
    public static final int SWISS_BALL_REVERSE_CRUNCH = 69;
    public static final int WEIGHTED_SWISS_BALL_REVERSE_CRUNCH = 70;
    public static final int SWISS_BALL_RUSSIAN_TWIST = 71;
    public static final int WEIGHTED_SWISS_BALL_RUSSIAN_TWIST = 72;
    public static final int SWISS_BALL_SIDE_CRUNCH = 73;
    public static final int WEIGHTED_SWISS_BALL_SIDE_CRUNCH = 74;
    public static final int THORACIC_CRUNCHES_ON_FOAM_ROLLER = 75;
    public static final int WEIGHTED_THORACIC_CRUNCHES_ON_FOAM_ROLLER = 76;
    public static final int TRICEPS_CRUNCH = 77;
    public static final int WEIGHTED_BICYCLE_CRUNCH = 78;
    public static final int WEIGHTED_CRUNCH = 79;
    public static final int WEIGHTED_SWISS_BALL_CRUNCH = 80;
    public static final int TOES_TO_BAR = 81;
    public static final int WEIGHTED_TOES_TO_BAR = 82;
    public static final int CRUNCH = 83;
    public static final int STRAIGHT_LEG_CRUNCH_WITH_BALL = 84;
    public static final int INVALID = Fit.UINT16_INVALID;

    private static final Map<Integer, String> stringMap;

    static {
        stringMap = new HashMap<Integer, String>();
        stringMap.put(BICYCLE_CRUNCH, "BICYCLE_CRUNCH");
        stringMap.put(CABLE_CRUNCH, "CABLE_CRUNCH");
        stringMap.put(CIRCULAR_ARM_CRUNCH, "CIRCULAR_ARM_CRUNCH");
        stringMap.put(CROSSED_ARMS_CRUNCH, "CROSSED_ARMS_CRUNCH");
        stringMap.put(WEIGHTED_CROSSED_ARMS_CRUNCH, "WEIGHTED_CROSSED_ARMS_CRUNCH");
        stringMap.put(CROSS_LEG_REVERSE_CRUNCH, "CROSS_LEG_REVERSE_CRUNCH");
        stringMap.put(WEIGHTED_CROSS_LEG_REVERSE_CRUNCH, "WEIGHTED_CROSS_LEG_REVERSE_CRUNCH");
        stringMap.put(CRUNCH_CHOP, "CRUNCH_CHOP");
        stringMap.put(WEIGHTED_CRUNCH_CHOP, "WEIGHTED_CRUNCH_CHOP");
        stringMap.put(DOUBLE_CRUNCH, "DOUBLE_CRUNCH");
        stringMap.put(WEIGHTED_DOUBLE_CRUNCH, "WEIGHTED_DOUBLE_CRUNCH");
        stringMap.put(ELBOW_TO_KNEE_CRUNCH, "ELBOW_TO_KNEE_CRUNCH");
        stringMap.put(WEIGHTED_ELBOW_TO_KNEE_CRUNCH, "WEIGHTED_ELBOW_TO_KNEE_CRUNCH");
        stringMap.put(FLUTTER_KICKS, "FLUTTER_KICKS");
        stringMap.put(WEIGHTED_FLUTTER_KICKS, "WEIGHTED_FLUTTER_KICKS");
        stringMap.put(FOAM_ROLLER_REVERSE_CRUNCH_ON_BENCH, "FOAM_ROLLER_REVERSE_CRUNCH_ON_BENCH");
        stringMap.put(WEIGHTED_FOAM_ROLLER_REVERSE_CRUNCH_ON_BENCH, "WEIGHTED_FOAM_ROLLER_REVERSE_CRUNCH_ON_BENCH");
        stringMap.put(FOAM_ROLLER_REVERSE_CRUNCH_WITH_DUMBBELL, "FOAM_ROLLER_REVERSE_CRUNCH_WITH_DUMBBELL");
        stringMap.put(FOAM_ROLLER_REVERSE_CRUNCH_WITH_MEDICINE_BALL, "FOAM_ROLLER_REVERSE_CRUNCH_WITH_MEDICINE_BALL");
        stringMap.put(FROG_PRESS, "FROG_PRESS");
        stringMap.put(HANGING_KNEE_RAISE_OBLIQUE_CRUNCH, "HANGING_KNEE_RAISE_OBLIQUE_CRUNCH");
        stringMap.put(WEIGHTED_HANGING_KNEE_RAISE_OBLIQUE_CRUNCH, "WEIGHTED_HANGING_KNEE_RAISE_OBLIQUE_CRUNCH");
        stringMap.put(HIP_CROSSOVER, "HIP_CROSSOVER");
        stringMap.put(WEIGHTED_HIP_CROSSOVER, "WEIGHTED_HIP_CROSSOVER");
        stringMap.put(HOLLOW_ROCK, "HOLLOW_ROCK");
        stringMap.put(WEIGHTED_HOLLOW_ROCK, "WEIGHTED_HOLLOW_ROCK");
        stringMap.put(INCLINE_REVERSE_CRUNCH, "INCLINE_REVERSE_CRUNCH");
        stringMap.put(WEIGHTED_INCLINE_REVERSE_CRUNCH, "WEIGHTED_INCLINE_REVERSE_CRUNCH");
        stringMap.put(KNEELING_CABLE_CRUNCH, "KNEELING_CABLE_CRUNCH");
        stringMap.put(KNEELING_CROSS_CRUNCH, "KNEELING_CROSS_CRUNCH");
        stringMap.put(WEIGHTED_KNEELING_CROSS_CRUNCH, "WEIGHTED_KNEELING_CROSS_CRUNCH");
        stringMap.put(KNEELING_OBLIQUE_CABLE_CRUNCH, "KNEELING_OBLIQUE_CABLE_CRUNCH");
        stringMap.put(KNEES_TO_ELBOW, "KNEES_TO_ELBOW");
        stringMap.put(LEG_EXTENSIONS, "LEG_EXTENSIONS");
        stringMap.put(WEIGHTED_LEG_EXTENSIONS, "WEIGHTED_LEG_EXTENSIONS");
        stringMap.put(LEG_LEVERS, "LEG_LEVERS");
        stringMap.put(MCGILL_CURL_UP, "MCGILL_CURL_UP");
        stringMap.put(WEIGHTED_MCGILL_CURL_UP, "WEIGHTED_MCGILL_CURL_UP");
        stringMap.put(MODIFIED_PILATES_ROLL_UP_WITH_BALL, "MODIFIED_PILATES_ROLL_UP_WITH_BALL");
        stringMap.put(WEIGHTED_MODIFIED_PILATES_ROLL_UP_WITH_BALL, "WEIGHTED_MODIFIED_PILATES_ROLL_UP_WITH_BALL");
        stringMap.put(PILATES_CRUNCH, "PILATES_CRUNCH");
        stringMap.put(WEIGHTED_PILATES_CRUNCH, "WEIGHTED_PILATES_CRUNCH");
        stringMap.put(PILATES_ROLL_UP_WITH_BALL, "PILATES_ROLL_UP_WITH_BALL");
        stringMap.put(WEIGHTED_PILATES_ROLL_UP_WITH_BALL, "WEIGHTED_PILATES_ROLL_UP_WITH_BALL");
        stringMap.put(RAISED_LEGS_CRUNCH, "RAISED_LEGS_CRUNCH");
        stringMap.put(WEIGHTED_RAISED_LEGS_CRUNCH, "WEIGHTED_RAISED_LEGS_CRUNCH");
        stringMap.put(REVERSE_CRUNCH, "REVERSE_CRUNCH");
        stringMap.put(WEIGHTED_REVERSE_CRUNCH, "WEIGHTED_REVERSE_CRUNCH");
        stringMap.put(REVERSE_CRUNCH_ON_A_BENCH, "REVERSE_CRUNCH_ON_A_BENCH");
        stringMap.put(WEIGHTED_REVERSE_CRUNCH_ON_A_BENCH, "WEIGHTED_REVERSE_CRUNCH_ON_A_BENCH");
        stringMap.put(REVERSE_CURL_AND_LIFT, "REVERSE_CURL_AND_LIFT");
        stringMap.put(WEIGHTED_REVERSE_CURL_AND_LIFT, "WEIGHTED_REVERSE_CURL_AND_LIFT");
        stringMap.put(ROTATIONAL_LIFT, "ROTATIONAL_LIFT");
        stringMap.put(WEIGHTED_ROTATIONAL_LIFT, "WEIGHTED_ROTATIONAL_LIFT");
        stringMap.put(SEATED_ALTERNATING_REVERSE_CRUNCH, "SEATED_ALTERNATING_REVERSE_CRUNCH");
        stringMap.put(WEIGHTED_SEATED_ALTERNATING_REVERSE_CRUNCH, "WEIGHTED_SEATED_ALTERNATING_REVERSE_CRUNCH");
        stringMap.put(SEATED_LEG_U, "SEATED_LEG_U");
        stringMap.put(WEIGHTED_SEATED_LEG_U, "WEIGHTED_SEATED_LEG_U");
        stringMap.put(SIDE_TO_SIDE_CRUNCH_AND_WEAVE, "SIDE_TO_SIDE_CRUNCH_AND_WEAVE");
        stringMap.put(WEIGHTED_SIDE_TO_SIDE_CRUNCH_AND_WEAVE, "WEIGHTED_SIDE_TO_SIDE_CRUNCH_AND_WEAVE");
        stringMap.put(SINGLE_LEG_REVERSE_CRUNCH, "SINGLE_LEG_REVERSE_CRUNCH");
        stringMap.put(WEIGHTED_SINGLE_LEG_REVERSE_CRUNCH, "WEIGHTED_SINGLE_LEG_REVERSE_CRUNCH");
        stringMap.put(SKATER_CRUNCH_CROSS, "SKATER_CRUNCH_CROSS");
        stringMap.put(WEIGHTED_SKATER_CRUNCH_CROSS, "WEIGHTED_SKATER_CRUNCH_CROSS");
        stringMap.put(STANDING_CABLE_CRUNCH, "STANDING_CABLE_CRUNCH");
        stringMap.put(STANDING_SIDE_CRUNCH, "STANDING_SIDE_CRUNCH");
        stringMap.put(STEP_CLIMB, "STEP_CLIMB");
        stringMap.put(WEIGHTED_STEP_CLIMB, "WEIGHTED_STEP_CLIMB");
        stringMap.put(SWISS_BALL_CRUNCH, "SWISS_BALL_CRUNCH");
        stringMap.put(SWISS_BALL_REVERSE_CRUNCH, "SWISS_BALL_REVERSE_CRUNCH");
        stringMap.put(WEIGHTED_SWISS_BALL_REVERSE_CRUNCH, "WEIGHTED_SWISS_BALL_REVERSE_CRUNCH");
        stringMap.put(SWISS_BALL_RUSSIAN_TWIST, "SWISS_BALL_RUSSIAN_TWIST");
        stringMap.put(WEIGHTED_SWISS_BALL_RUSSIAN_TWIST, "WEIGHTED_SWISS_BALL_RUSSIAN_TWIST");
        stringMap.put(SWISS_BALL_SIDE_CRUNCH, "SWISS_BALL_SIDE_CRUNCH");
        stringMap.put(WEIGHTED_SWISS_BALL_SIDE_CRUNCH, "WEIGHTED_SWISS_BALL_SIDE_CRUNCH");
        stringMap.put(THORACIC_CRUNCHES_ON_FOAM_ROLLER, "THORACIC_CRUNCHES_ON_FOAM_ROLLER");
        stringMap.put(WEIGHTED_THORACIC_CRUNCHES_ON_FOAM_ROLLER, "WEIGHTED_THORACIC_CRUNCHES_ON_FOAM_ROLLER");
        stringMap.put(TRICEPS_CRUNCH, "TRICEPS_CRUNCH");
        stringMap.put(WEIGHTED_BICYCLE_CRUNCH, "WEIGHTED_BICYCLE_CRUNCH");
        stringMap.put(WEIGHTED_CRUNCH, "WEIGHTED_CRUNCH");
        stringMap.put(WEIGHTED_SWISS_BALL_CRUNCH, "WEIGHTED_SWISS_BALL_CRUNCH");
        stringMap.put(TOES_TO_BAR, "TOES_TO_BAR");
        stringMap.put(WEIGHTED_TOES_TO_BAR, "WEIGHTED_TOES_TO_BAR");
        stringMap.put(CRUNCH, "CRUNCH");
        stringMap.put(STRAIGHT_LEG_CRUNCH_WITH_BALL, "STRAIGHT_LEG_CRUNCH_WITH_BALL");
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
