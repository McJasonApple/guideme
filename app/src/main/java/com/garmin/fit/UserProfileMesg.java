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
import java.math.BigInteger;


public class UserProfileMesg extends Mesg {

    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int FriendlyNameFieldNum = 0;
    
    public static final int GenderFieldNum = 1;
    
    public static final int AgeFieldNum = 2;
    
    public static final int HeightFieldNum = 3;
    
    public static final int WeightFieldNum = 4;
    
    public static final int LanguageFieldNum = 5;
    
    public static final int ElevSettingFieldNum = 6;
    
    public static final int WeightSettingFieldNum = 7;
    
    public static final int RestingHeartRateFieldNum = 8;
    
    public static final int DefaultMaxRunningHeartRateFieldNum = 9;
    
    public static final int DefaultMaxBikingHeartRateFieldNum = 10;
    
    public static final int DefaultMaxHeartRateFieldNum = 11;
    
    public static final int HrSettingFieldNum = 12;
    
    public static final int SpeedSettingFieldNum = 13;
    
    public static final int DistSettingFieldNum = 14;
    
    public static final int PowerSettingFieldNum = 16;
    
    public static final int ActivityClassFieldNum = 17;
    
    public static final int PositionSettingFieldNum = 18;
    
    public static final int TemperatureSettingFieldNum = 21;
    
    public static final int LocalIdFieldNum = 22;
    
    public static final int GlobalIdFieldNum = 23;
    
    public static final int WakeTimeFieldNum = 28;
    
    public static final int SleepTimeFieldNum = 29;
    
    public static final int HeightSettingFieldNum = 30;
    
    public static final int UserRunningStepLengthFieldNum = 31;
    
    public static final int UserWalkingStepLengthFieldNum = 32;
    
    public static final int DepthSettingFieldNum = 47;
    
    public static final int DiveCountFieldNum = 49;
    

    protected static final  Mesg userProfileMesg;
    static {
        // user_profile
        userProfileMesg = new Mesg("user_profile", MesgNum.USER_PROFILE);
        userProfileMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        userProfileMesg.addField(new Field("friendly_name", FriendlyNameFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
        userProfileMesg.addField(new Field("gender", GenderFieldNum, 0, 1, 0, "", false, Profile.Type.GENDER));
        
        userProfileMesg.addField(new Field("age", AgeFieldNum, 2, 1, 0, "years", false, Profile.Type.UINT8));
        
        userProfileMesg.addField(new Field("height", HeightFieldNum, 2, 100, 0, "m", false, Profile.Type.UINT8));
        
        userProfileMesg.addField(new Field("weight", WeightFieldNum, 132, 10, 0, "kg", false, Profile.Type.UINT16));
        
        userProfileMesg.addField(new Field("language", LanguageFieldNum, 0, 1, 0, "", false, Profile.Type.LANGUAGE));
        
        userProfileMesg.addField(new Field("elev_setting", ElevSettingFieldNum, 0, 1, 0, "", false, Profile.Type.DISPLAY_MEASURE));
        
        userProfileMesg.addField(new Field("weight_setting", WeightSettingFieldNum, 0, 1, 0, "", false, Profile.Type.DISPLAY_MEASURE));
        
        userProfileMesg.addField(new Field("resting_heart_rate", RestingHeartRateFieldNum, 2, 1, 0, "bpm", false, Profile.Type.UINT8));
        
        userProfileMesg.addField(new Field("default_max_running_heart_rate", DefaultMaxRunningHeartRateFieldNum, 2, 1, 0, "bpm", false, Profile.Type.UINT8));
        
        userProfileMesg.addField(new Field("default_max_biking_heart_rate", DefaultMaxBikingHeartRateFieldNum, 2, 1, 0, "bpm", false, Profile.Type.UINT8));
        
        userProfileMesg.addField(new Field("default_max_heart_rate", DefaultMaxHeartRateFieldNum, 2, 1, 0, "bpm", false, Profile.Type.UINT8));
        
        userProfileMesg.addField(new Field("hr_setting", HrSettingFieldNum, 0, 1, 0, "", false, Profile.Type.DISPLAY_HEART));
        
        userProfileMesg.addField(new Field("speed_setting", SpeedSettingFieldNum, 0, 1, 0, "", false, Profile.Type.DISPLAY_MEASURE));
        
        userProfileMesg.addField(new Field("dist_setting", DistSettingFieldNum, 0, 1, 0, "", false, Profile.Type.DISPLAY_MEASURE));
        
        userProfileMesg.addField(new Field("power_setting", PowerSettingFieldNum, 0, 1, 0, "", false, Profile.Type.DISPLAY_POWER));
        
        userProfileMesg.addField(new Field("activity_class", ActivityClassFieldNum, 0, 1, 0, "", false, Profile.Type.ACTIVITY_CLASS));
        
        userProfileMesg.addField(new Field("position_setting", PositionSettingFieldNum, 0, 1, 0, "", false, Profile.Type.DISPLAY_POSITION));
        
        userProfileMesg.addField(new Field("temperature_setting", TemperatureSettingFieldNum, 0, 1, 0, "", false, Profile.Type.DISPLAY_MEASURE));
        
        userProfileMesg.addField(new Field("local_id", LocalIdFieldNum, 132, 1, 0, "", false, Profile.Type.USER_LOCAL_ID));
        
        userProfileMesg.addField(new Field("global_id", GlobalIdFieldNum, 13, 1, 0, "", false, Profile.Type.BYTE));
        
        userProfileMesg.addField(new Field("wake_time", WakeTimeFieldNum, 134, 1, 0, "", false, Profile.Type.LOCALTIME_INTO_DAY));
        
        userProfileMesg.addField(new Field("sleep_time", SleepTimeFieldNum, 134, 1, 0, "", false, Profile.Type.LOCALTIME_INTO_DAY));
        
        userProfileMesg.addField(new Field("height_setting", HeightSettingFieldNum, 0, 1, 0, "", false, Profile.Type.DISPLAY_MEASURE));
        
        userProfileMesg.addField(new Field("user_running_step_length", UserRunningStepLengthFieldNum, 132, 1000, 0, "m", false, Profile.Type.UINT16));
        
        userProfileMesg.addField(new Field("user_walking_step_length", UserWalkingStepLengthFieldNum, 132, 1000, 0, "m", false, Profile.Type.UINT16));
        
        userProfileMesg.addField(new Field("depth_setting", DepthSettingFieldNum, 0, 1, 0, "", false, Profile.Type.DISPLAY_MEASURE));
        
        userProfileMesg.addField(new Field("dive_count", DiveCountFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        
    }

    public UserProfileMesg() {
        super(Factory.createMesg(MesgNum.USER_PROFILE));
    }

    public UserProfileMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get message_index field
     *
     * @return message_index
     */
    public Integer getMessageIndex() {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set message_index field
     *
     * @param messageIndex
     */
    public void setMessageIndex(Integer messageIndex) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get friendly_name field
     *
     * @return friendly_name
     */
    public String getFriendlyName() {
        return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set friendly_name field
     *
     * @param friendlyName
     */
    public void setFriendlyName(String friendlyName) {
        setFieldValue(0, 0, friendlyName, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get gender field
     *
     * @return gender
     */
    public Gender getGender() {
        Short value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Gender.getByValue(value);
    }

    /**
     * Set gender field
     *
     * @param gender
     */
    public void setGender(Gender gender) {
        setFieldValue(1, 0, gender.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get age field
     * Units: years
     *
     * @return age
     */
    public Short getAge() {
        return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set age field
     * Units: years
     *
     * @param age
     */
    public void setAge(Short age) {
        setFieldValue(2, 0, age, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get height field
     * Units: m
     *
     * @return height
     */
    public Float getHeight() {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set height field
     * Units: m
     *
     * @param height
     */
    public void setHeight(Float height) {
        setFieldValue(3, 0, height, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get weight field
     * Units: kg
     *
     * @return weight
     */
    public Float getWeight() {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set weight field
     * Units: kg
     *
     * @param weight
     */
    public void setWeight(Float weight) {
        setFieldValue(4, 0, weight, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get language field
     *
     * @return language
     */
    public Language getLanguage() {
        Short value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Language.getByValue(value);
    }

    /**
     * Set language field
     *
     * @param language
     */
    public void setLanguage(Language language) {
        setFieldValue(5, 0, language.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get elev_setting field
     *
     * @return elev_setting
     */
    public DisplayMeasure getElevSetting() {
        Short value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DisplayMeasure.getByValue(value);
    }

    /**
     * Set elev_setting field
     *
     * @param elevSetting
     */
    public void setElevSetting(DisplayMeasure elevSetting) {
        setFieldValue(6, 0, elevSetting.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get weight_setting field
     *
     * @return weight_setting
     */
    public DisplayMeasure getWeightSetting() {
        Short value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DisplayMeasure.getByValue(value);
    }

    /**
     * Set weight_setting field
     *
     * @param weightSetting
     */
    public void setWeightSetting(DisplayMeasure weightSetting) {
        setFieldValue(7, 0, weightSetting.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get resting_heart_rate field
     * Units: bpm
     *
     * @return resting_heart_rate
     */
    public Short getRestingHeartRate() {
        return getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set resting_heart_rate field
     * Units: bpm
     *
     * @param restingHeartRate
     */
    public void setRestingHeartRate(Short restingHeartRate) {
        setFieldValue(8, 0, restingHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get default_max_running_heart_rate field
     * Units: bpm
     *
     * @return default_max_running_heart_rate
     */
    public Short getDefaultMaxRunningHeartRate() {
        return getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set default_max_running_heart_rate field
     * Units: bpm
     *
     * @param defaultMaxRunningHeartRate
     */
    public void setDefaultMaxRunningHeartRate(Short defaultMaxRunningHeartRate) {
        setFieldValue(9, 0, defaultMaxRunningHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get default_max_biking_heart_rate field
     * Units: bpm
     *
     * @return default_max_biking_heart_rate
     */
    public Short getDefaultMaxBikingHeartRate() {
        return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set default_max_biking_heart_rate field
     * Units: bpm
     *
     * @param defaultMaxBikingHeartRate
     */
    public void setDefaultMaxBikingHeartRate(Short defaultMaxBikingHeartRate) {
        setFieldValue(10, 0, defaultMaxBikingHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get default_max_heart_rate field
     * Units: bpm
     *
     * @return default_max_heart_rate
     */
    public Short getDefaultMaxHeartRate() {
        return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set default_max_heart_rate field
     * Units: bpm
     *
     * @param defaultMaxHeartRate
     */
    public void setDefaultMaxHeartRate(Short defaultMaxHeartRate) {
        setFieldValue(11, 0, defaultMaxHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get hr_setting field
     *
     * @return hr_setting
     */
    public DisplayHeart getHrSetting() {
        Short value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DisplayHeart.getByValue(value);
    }

    /**
     * Set hr_setting field
     *
     * @param hrSetting
     */
    public void setHrSetting(DisplayHeart hrSetting) {
        setFieldValue(12, 0, hrSetting.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get speed_setting field
     *
     * @return speed_setting
     */
    public DisplayMeasure getSpeedSetting() {
        Short value = getFieldShortValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DisplayMeasure.getByValue(value);
    }

    /**
     * Set speed_setting field
     *
     * @param speedSetting
     */
    public void setSpeedSetting(DisplayMeasure speedSetting) {
        setFieldValue(13, 0, speedSetting.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get dist_setting field
     *
     * @return dist_setting
     */
    public DisplayMeasure getDistSetting() {
        Short value = getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DisplayMeasure.getByValue(value);
    }

    /**
     * Set dist_setting field
     *
     * @param distSetting
     */
    public void setDistSetting(DisplayMeasure distSetting) {
        setFieldValue(14, 0, distSetting.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get power_setting field
     *
     * @return power_setting
     */
    public DisplayPower getPowerSetting() {
        Short value = getFieldShortValue(16, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DisplayPower.getByValue(value);
    }

    /**
     * Set power_setting field
     *
     * @param powerSetting
     */
    public void setPowerSetting(DisplayPower powerSetting) {
        setFieldValue(16, 0, powerSetting.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get activity_class field
     *
     * @return activity_class
     */
    public ActivityClass getActivityClass() {
        Short value = getFieldShortValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return ActivityClass.getByValue(value);
    }

    /**
     * Set activity_class field
     *
     * @param activityClass
     */
    public void setActivityClass(ActivityClass activityClass) {
        setFieldValue(17, 0, activityClass.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get position_setting field
     *
     * @return position_setting
     */
    public DisplayPosition getPositionSetting() {
        Short value = getFieldShortValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DisplayPosition.getByValue(value);
    }

    /**
     * Set position_setting field
     *
     * @param positionSetting
     */
    public void setPositionSetting(DisplayPosition positionSetting) {
        setFieldValue(18, 0, positionSetting.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get temperature_setting field
     *
     * @return temperature_setting
     */
    public DisplayMeasure getTemperatureSetting() {
        Short value = getFieldShortValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DisplayMeasure.getByValue(value);
    }

    /**
     * Set temperature_setting field
     *
     * @param temperatureSetting
     */
    public void setTemperatureSetting(DisplayMeasure temperatureSetting) {
        setFieldValue(21, 0, temperatureSetting.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get local_id field
     *
     * @return local_id
     */
    public Integer getLocalId() {
        return getFieldIntegerValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set local_id field
     *
     * @param localId
     */
    public void setLocalId(Integer localId) {
        setFieldValue(22, 0, localId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Byte[] getGlobalId() {
        
        return getFieldByteValues(23, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of global_id
     */
    public int getNumGlobalId() {
        return getNumFieldValues(23, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get global_id field
     *
     * @param index of global_id
     * @return global_id
     */
    public Byte getGlobalId(int index) {
        return getFieldByteValue(23, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set global_id field
     *
     * @param index of global_id
     * @param globalId
     */
    public void setGlobalId(int index, Byte globalId) {
        setFieldValue(23, index, globalId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get wake_time field
     * Comment: Typical wake time
     *
     * @return wake_time
     */
    public Long getWakeTime() {
        return getFieldLongValue(28, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set wake_time field
     * Comment: Typical wake time
     *
     * @param wakeTime
     */
    public void setWakeTime(Long wakeTime) {
        setFieldValue(28, 0, wakeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sleep_time field
     * Comment: Typical bed time
     *
     * @return sleep_time
     */
    public Long getSleepTime() {
        return getFieldLongValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set sleep_time field
     * Comment: Typical bed time
     *
     * @param sleepTime
     */
    public void setSleepTime(Long sleepTime) {
        setFieldValue(29, 0, sleepTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get height_setting field
     *
     * @return height_setting
     */
    public DisplayMeasure getHeightSetting() {
        Short value = getFieldShortValue(30, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DisplayMeasure.getByValue(value);
    }

    /**
     * Set height_setting field
     *
     * @param heightSetting
     */
    public void setHeightSetting(DisplayMeasure heightSetting) {
        setFieldValue(30, 0, heightSetting.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get user_running_step_length field
     * Units: m
     * Comment: User defined running step length set to 0 for auto length
     *
     * @return user_running_step_length
     */
    public Float getUserRunningStepLength() {
        return getFieldFloatValue(31, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set user_running_step_length field
     * Units: m
     * Comment: User defined running step length set to 0 for auto length
     *
     * @param userRunningStepLength
     */
    public void setUserRunningStepLength(Float userRunningStepLength) {
        setFieldValue(31, 0, userRunningStepLength, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get user_walking_step_length field
     * Units: m
     * Comment: User defined walking step length set to 0 for auto length
     *
     * @return user_walking_step_length
     */
    public Float getUserWalkingStepLength() {
        return getFieldFloatValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set user_walking_step_length field
     * Units: m
     * Comment: User defined walking step length set to 0 for auto length
     *
     * @param userWalkingStepLength
     */
    public void setUserWalkingStepLength(Float userWalkingStepLength) {
        setFieldValue(32, 0, userWalkingStepLength, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get depth_setting field
     *
     * @return depth_setting
     */
    public DisplayMeasure getDepthSetting() {
        Short value = getFieldShortValue(47, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DisplayMeasure.getByValue(value);
    }

    /**
     * Set depth_setting field
     *
     * @param depthSetting
     */
    public void setDepthSetting(DisplayMeasure depthSetting) {
        setFieldValue(47, 0, depthSetting.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get dive_count field
     *
     * @return dive_count
     */
    public Long getDiveCount() {
        return getFieldLongValue(49, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set dive_count field
     *
     * @param diveCount
     */
    public void setDiveCount(Long diveCount) {
        setFieldValue(49, 0, diveCount, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
