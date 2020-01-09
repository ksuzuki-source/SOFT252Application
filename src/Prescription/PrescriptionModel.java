/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author kouss
 */
public class PrescriptionModel implements Serializable{
    private int prescriptionID;
    private String patientID;
    private String doctorID;
    private String notes;
    private String date; 
    MedicineModel medicine;
    private boolean Completed = false;

    /**
     * constructor to set up a prescription
     * @param patient
     * @param doctor
     * @param notes
     */
    public PrescriptionModel(String patient, String doctor, String notes) {
        this.patientID = patient;
        this.doctorID = doctor;
        this.notes = notes;
    }

    /**
     * constructor to set up a prescription
     * @param prescriptionID
     * @param patientID
     * @param doctorID
     * @param notes
     * @param date
     * @param medicine
     */
    public PrescriptionModel(int prescriptionID, String patientID, String doctorID, String notes, String date, MedicineModel medicine) {
        this.prescriptionID = prescriptionID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.notes = notes;
        this.date = date;
        this.medicine = medicine;
    }
    
    /**
     * get the date prescriped
     * @return a localDateTime of the date prescriped
     */
    public String getDatePrescriped() {
        return date;
    }

    /**
     * set the localdatatime of the date prescriped
     * @param datePrescriped
     */
    public void setDatePrescriped(LocalDateTime datePrescriped) {
        this.date = date;
    }
    
    /**
     * get the patientID
     * @return the string patientID
     */
    public String getPatient() {
        return patientID;
    }

    /**
     * set the patientID
     * @param patient
     */
    public void setPatient(String patient) {
        this.patientID = patient;
    }

    /**
     * get the doctor ID
     * @return the string doctorID
     */
    public String getDoctor() {
        return doctorID;
    }

    /**
     * set the doctor ID
     * @param doctor
     */
    public void setDoctor(String doctor) {
        this.doctorID = doctor;
    }

    /**
     * get the prescription notes
     * @return String Notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * set the prescription notes
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * get the medicines
     * @return an object medicine
     */
    public MedicineModel getMedicine() {
        return medicine;
    }

    /**
     * set the medicine 
     * @param medicine
     */
    public void setMedicine(MedicineModel medicine) {
        this.medicine = medicine;
    }
    
    /**
     * When the prescription is complete then this method will be called
     */
    public void completePrescription(){
        this.Completed = true;
    }

    /**
     * get the prescription ID
     * @return the precription ID
     */
    public int getPrescriptionID() {
        return prescriptionID;
    }

    /**
     * set the prescription ID
     * @param prescriptionID
     */
    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    /**
     * check Complete
     * @return if completed
     */
    public boolean isCompleted() {
        return Completed;
    }
}
