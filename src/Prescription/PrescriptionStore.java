/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kouss
 */
public class PrescriptionStore implements Serializable{
    ArrayList<PrescriptionModel> prescriptions= new ArrayList<>();

    /**
     *Constructor for the prescription storage
     */
    public PrescriptionStore() {
    }

    /**
     *adds prescription by passing in a prescription object
     * @param prescription
     */
    public void addPrescription(PrescriptionModel prescription) {
        this.prescriptions.add(prescription);
    }

    /**
     * removes prescription by passing in a prescription object
     * @param prescription
     */
    public void removePrescriptions(PrescriptionModel prescription) {
        prescriptions.remove(prescription);
    }

    /**
     *find prescription by passing in a prescription object
     * @param prescription
     * @return index of the prescription integer
     */
    public PrescriptionModel findPrescription(PrescriptionModel prescription) {
        int index = prescriptions.indexOf(prescription);
        return prescriptions.get(index);
    }

    /**
     *gets all the prescriptions
     * @return array list of the prescription objects 
     */
    public ArrayList<PrescriptionModel> getPrescriptions() {
        return this.prescriptions;
    }
    
}
