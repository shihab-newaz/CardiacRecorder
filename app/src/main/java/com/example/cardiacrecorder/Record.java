package com.example.cardiacrecorder;

/**
 * This is a class that stores data for a particular record
 */
public class Record implements Comparable<Record> {
    private String date;
    private String time;
    private String systolic;
    private String diastolic;
    private String heartRate;
    private String comment;
    private String bpStatus;
    private String heartRateStatus;

    public Record()
    {

    }

    /**
     * constructor is declared here
     * @param date
     * date
     * @param time
     * time
     * @param systolic
     * systolic
     * @param diastolic
     * diastolic
     * @param heartRate
     * heartRate
     * @param comment
     * comment
     * @param bpStatus
     * blood pressure status
     * @param  heartRateStatus
     *  heart Rate Status
     */

    public Record(String date, String time, String systolic, String diastolic, String heartRate, String comment, String bpStatus, String heartRateStatus) {
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartRate = heartRate;
        this.comment = comment;
        this.bpStatus = bpStatus;
        this.heartRateStatus = heartRateStatus;
    }

    /**
     * getter for date
     * @return
     * String
     */
    public String getDate() {
        return date;
    }

    /**
     * setter for date
     * @param date
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * getter for time
     * @return
     * String
     */

    public String getTime() {
        return time;
    }

    /**
     * setter for time
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * getter for systolic
     * @return
     * String
     */

    public String getSystolic() {
        return systolic;
    }

    /**
     * setter for systolic
     * @param systolic
     */

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    /**
     * getter for diastolic
     * @return
     * String
     */
    public String getDiastolic() {
        return diastolic;
    }

    /**
     * setter for diastolic
     * @param diastolic
     */
    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    /**
     * getter for heartRate
     * @return
     * string
     */

    public String getHeartRate() {
        return heartRate;
    }

    /**
     * setter for heartRate
     * @param heartRate
     */

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * getter for comment
     * @return
     * String
     */
    public String getComment() {
        return comment;
    }

    /**
     * setter for comment
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }


    /**
     * getter for blood pressure status
     * @return
     * String
     */

    public String getBpStatus() {
        return bpStatus;
    }

    /**
     * setter for blood pressure status
     * @param bpStatus
     */

    public void setBpStatus(String bpStatus) {
        this.bpStatus = bpStatus;
    }

    /**
     * getter for heart rate status
     * @return
     * String
     */
    public String getHeartRateStatus() {
        return heartRateStatus;
    }

    /**
     * setter for heart rate status
     * @param heartRateStatus
     */
    public void setHeartRateStatus(String heartRateStatus) {
        this.heartRateStatus = heartRateStatus;
    }

    @Override
    public int compareTo(Record record) {
        return 0;
    }
}
