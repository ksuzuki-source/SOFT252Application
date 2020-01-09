/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kouss
 */


public class DoctorFeedbackStore implements IDoctorFeedback , Serializable{
    private ArrayList<DoctorFeedback> doctorsFeedback = new ArrayList<>();

    /**
     * Constructor to initialise the storage
     */
    public DoctorFeedbackStore() {
    }
    
    /**
     * 
     * adds the doctor feedback by passing in a DoctorFeedback object
     * @param doctorFeedback
     */
    @Override
    public void addDoctorFeedback(DoctorFeedback doctorFeedback) {
        this.doctorsFeedback.add(doctorFeedback);
    }

    /**
     * removes the doctor feedback by passing in a DoctorFeedback object
     * @param doctorFeedback
     */
    @Override
    public void removeDoctorFeedback(DoctorFeedback doctorFeedback) {
        doctorsFeedback.remove(doctorFeedback);
    }

    /**
     *finds the doctor feedback by passing in a DoctorFeedback object
     * @param doctorFeedback
     * @return the index of the doctorFeedback
     */
    @Override
    public DoctorFeedback findDoctorFeedback(DoctorFeedback doctorFeedback) {
        int index = doctorsFeedback.indexOf(doctorFeedback);
        return doctorsFeedback.get(index);
    }

    /**
     *gets all of the feedback
     * @return array list of DoctorFeedback objects
     */
    @Override
    public ArrayList<DoctorFeedback> getDoctorsFeedback() {
        return doctorsFeedback;
    }
    
    
}
