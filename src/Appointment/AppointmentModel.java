/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 *
 * @author kouss
 */
public class AppointmentModel implements Serializable{
    private int AppointmentID;
    private String Date;
    private String doctorID;
    private String patientID;
    private String reason;
    private String notes;
    private boolean completed = false;

    /**
     *
     * @param AppointmentID
     * @param Date
     * @param doctorID
     * @param patientID
     * @param reason
     */
    public AppointmentModel(int AppointmentID, String Date, String doctorID, String patientID, String reason) {
        this.AppointmentID = AppointmentID;
        this.Date = Date;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.reason = reason;
    }

    /**
     *
     * @param AppointmentID
     * @param Date
     * @param doctorID
     * @param patientID
     */
    public AppointmentModel(int AppointmentID, String Date, String doctorID, String patientID) {
        this.AppointmentID = AppointmentID;
        this.Date = Date;
        this.doctorID = doctorID;
        this.patientID = patientID;
    }

    
    /**
     *
     * @return
     */
    public String getDate() {
        return Date;
    }

    /**
     *
     * @param Date
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     *
     * @return
     */
    public String getDoctorID() {
        return doctorID;
    }

    /**
     *
     * @param doctorID
     */
    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    /**
     *
     * @return
     */
    public String getPatientID() {
        return patientID;
    }

    /**
     *
     * @param patientID
     */
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    /**
     *
     * @return
     */
    public String getReason() {
        return reason;
    }

    /**
     *
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     *
     * @return
     */
    public int getAppointmentID() {
        return AppointmentID;
    }

    /**
     *
     * @param AppointmentID
     */
    public void setAppointmentID(int AppointmentID) {
        this.AppointmentID = AppointmentID;
    }

    /**
     *
     * @return
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     *
     * @return
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     *
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    
}
