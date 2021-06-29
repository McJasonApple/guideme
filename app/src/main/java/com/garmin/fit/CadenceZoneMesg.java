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


public class CadenceZoneMesg extends Mesg {

    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int HighValueFieldNum = 0;
    
    public static final int NameFieldNum = 1;
    

    protected static final  Mesg cadenceZoneMesg;
    static {
        // cadence_zone
        cadenceZoneMesg = new Mesg("cadence_zone", MesgNum.CADENCE_ZONE);
        cadenceZoneMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        cadenceZoneMesg.addField(new Field("high_value", HighValueFieldNum, 2, 1, 0, "rpm", false, Profile.Type.UINT8));
        
        cadenceZoneMesg.addField(new Field("name", NameFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
    }

    public CadenceZoneMesg() {
        super(Factory.createMesg(MesgNum.CADENCE_ZONE));
    }

    public CadenceZoneMesg(final Mesg mesg) {
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
     * Get high_value field
     * Units: rpm
     *
     * @return high_value
     */
    public Short getHighValue() {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set high_value field
     * Units: rpm
     *
     * @param highValue
     */
    public void setHighValue(Short highValue) {
        setFieldValue(0, 0, highValue, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get name field
     *
     * @return name
     */
    public String getName() {
        return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set name field
     *
     * @param name
     */
    public void setName(String name) {
        setFieldValue(1, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
