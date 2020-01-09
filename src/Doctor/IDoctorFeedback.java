/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import java.util.ArrayList;
/**
 *
 * @author kouss
 */
public interface IDoctorFeedback {
     /**
     * adds doctor feedback by passing in a doctor feedback object
     * @param doctorFeedback
     */
    public void addDoctorFeedback(DoctorFeedback doctorFeedback);

    /**
     *removes doctor feedback by passing in a doctor feedback object
     * @param doctorFeedback
     */
    public void removeDoctorFeedback(DoctorFeedback doctorFeedback);

    /**
     * finds doctor feedback by passing in a doctor feedback object
     * @param doctorFeedback
     * @return the index of the doctorFeedback
     */
    public DoctorFeedback findDoctorFeedback(DoctorFeedback doctorFeedback);

    /**
     * gets doctor feedback
     * @return the array list of doctors feedback
     */
    public ArrayList<DoctorFeedback> getDoctorsFeedback();
    
}
