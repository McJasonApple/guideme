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


public class DiveSummaryMesg extends Mesg {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int ReferenceMesgFieldNum = 0;
    
    public static final int ReferenceIndexFieldNum = 1;
    
    public static final int AvgDepthFieldNum = 2;
    
    public static final int MaxDepthFieldNum = 3;
    
    public static final int SurfaceIntervalFieldNum = 4;
    
    public static final int StartCnsFieldNum = 5;
    
    public static final int EndCnsFieldNum = 6;
    
    public static final int StartN2FieldNum = 7;
    
    public static final int EndN2FieldNum = 8;
    
    public static final int O2ToxicityFieldNum = 9;
    
    public static final int DiveNumberFieldNum = 10;
    
    public static final int BottomTimeFieldNum = 11;
    

    protected static final  Mesg diveSummaryMesg;
    static {
        // dive_summary
        diveSummaryMesg = new Mesg("dive_summary", MesgNum.DIVE_SUMMARY);
        diveSummaryMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        
        diveSummaryMesg.addField(new Field("reference_mesg", ReferenceMesgFieldNum, 132, 1, 0, "", false, Profile.Type.MESG_NUM));
        
        diveSummaryMesg.addField(new Field("reference_index", ReferenceIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        diveSummaryMesg.addField(new Field("avg_depth", AvgDepthFieldNum, 134, 1000, 0, "m", false, Profile.Type.UINT32));
        
        diveSummaryMesg.addField(new Field("max_depth", MaxDepthFieldNum, 134, 1000, 0, "m", false, Profile.Type.UINT32));
        
        diveSummaryMesg.addField(new Field("surface_interval", SurfaceIntervalFieldNum, 134, 1, 0, "s", false, Profile.Type.UINT32));
        
        diveSummaryMesg.addField(new Field("start_cns", StartCnsFieldNum, 2, 1, 0, "percent", false, Profile.Type.UINT8));
        
        diveSummaryMesg.addField(new Field("end_cns", EndCnsFieldNum, 2, 1, 0, "percent", false, Profile.Type.UINT8));
        
        diveSummaryMesg.addField(new Field("start_n2", StartN2FieldNum, 132, 1, 0, "percent", false, Profile.Type.UINT16));
        
        diveSummaryMesg.addField(new Field("end_n2", EndN2FieldNum, 132, 1, 0, "percent", false, Profile.Type.UINT16));
        
        diveSummaryMesg.addField(new Field("o2_toxicity", O2ToxicityFieldNum, 132, 1, 0, "OTUs", false, Profile.Type.UINT16));
        
        diveSummaryMesg.addField(new Field("dive_number", DiveNumberFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        
        diveSummaryMesg.addField(new Field("bottom_time", BottomTimeFieldNum, 134, 1000, 0, "s", false, Profile.Type.UINT32));
        
    }

    public DiveSummaryMesg() {
        super(Factory.createMesg(MesgNum.DIVE_SUMMARY));
    }

    public DiveSummaryMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get reference_mesg field
     *
     * @return reference_mesg
     */
    public Integer getReferenceMesg() {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set reference_mesg field
     *
     * @param referenceMesg
     */
    public void setReferenceMesg(Integer referenceMesg) {
        setFieldValue(0, 0, referenceMesg, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get reference_index field
     *
     * @return reference_index
     */
    public Integer getReferenceIndex() {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set reference_index field
     *
     * @param referenceIndex
     */
    public void setReferenceIndex(Integer referenceIndex) {
        setFieldValue(1, 0, referenceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get avg_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @return avg_depth
     */
    public Float getAvgDepth() {
        return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set avg_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @param avgDepth
     */
    public void setAvgDepth(Float avgDepth) {
        setFieldValue(2, 0, avgDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get max_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @return max_depth
     */
    public Float getMaxDepth() {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set max_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @param maxDepth
     */
    public void setMaxDepth(Float maxDepth) {
        setFieldValue(3, 0, maxDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get surface_interval field
     * Units: s
     * Comment: Time since end of last dive
     *
     * @return surface_interval
     */
    public Long getSurfaceInterval() {
        return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set surface_interval field
     * Units: s
     * Comment: Time since end of last dive
     *
     * @param surfaceInterval
     */
    public void setSurfaceInterval(Long surfaceInterval) {
        setFieldValue(4, 0, surfaceInterval, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get start_cns field
     * Units: percent
     *
     * @return start_cns
     */
    public Short getStartCns() {
        return getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set start_cns field
     * Units: percent
     *
     * @param startCns
     */
    public void setStartCns(Short startCns) {
        setFieldValue(5, 0, startCns, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get end_cns field
     * Units: percent
     *
     * @return end_cns
     */
    public Short getEndCns() {
        return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set end_cns field
     * Units: percent
     *
     * @param endCns
     */
    public void setEndCns(Short endCns) {
        setFieldValue(6, 0, endCns, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get start_n2 field
     * Units: percent
     *
     * @return start_n2
     */
    public Integer getStartN2() {
        return getFieldIntegerValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set start_n2 field
     * Units: percent
     *
     * @param startN2
     */
    public void setStartN2(Integer startN2) {
        setFieldValue(7, 0, startN2, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get end_n2 field
     * Units: percent
     *
     * @return end_n2
     */
    public Integer getEndN2() {
        return getFieldIntegerValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set end_n2 field
     * Units: percent
     *
     * @param endN2
     */
    public void setEndN2(Integer endN2) {
        setFieldValue(8, 0, endN2, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get o2_toxicity field
     * Units: OTUs
     *
     * @return o2_toxicity
     */
    public Integer getO2Toxicity() {
        return getFieldIntegerValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set o2_toxicity field
     * Units: OTUs
     *
     * @param o2Toxicity
     */
    public void setO2Toxicity(Integer o2Toxicity) {
        setFieldValue(9, 0, o2Toxicity, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get dive_number field
     *
     * @return dive_number
     */
    public Long getDiveNumber() {
        return getFieldLongValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set dive_number field
     *
     * @param diveNumber
     */
    public void setDiveNumber(Long diveNumber) {
        setFieldValue(10, 0, diveNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get bottom_time field
     * Units: s
     *
     * @return bottom_time
     */
    public Float getBottomTime() {
        return getFieldFloatValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set bottom_time field
     * Units: s
     *
     * @param bottomTime
     */
    public void setBottomTime(Float bottomTime) {
        setFieldValue(11, 0, bottomTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
