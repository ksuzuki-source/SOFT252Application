/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import java.io.Serializable;
/**
 *
 * @author kouss
 */
public class DoctorFeedback implements Serializable{
    private int doctorRatingID;
    private String doctorID;
    private int doctorRating;
    private String feedbackNotes;

    /**
     * Constructor to create doctor feedback
     * @param doctorID
     * @param doctorRating
     * @param feedbackNotes
     * @param doctorRatingID
     */
    public DoctorFeedback(String doctorID, int doctorRating, String feedbackNotes,int doctorRatingID) {
        this.doctorID = doctorID;
        this.doctorRating = doctorRating;
        this.feedbackNotes = feedbackNotes;
        this.doctorRatingID = doctorRatingID;
    }

    /**
     * get doctor ID
     * @return the doctor ID as a string
     */
    public String getDoctorID() {
        return doctorID;
    }

    /**
     *set doctorID
     * @param doctorID
     */
    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    /**
     * get rating 
     * @return the rating as an integer
     */
    public int getDoctorRating() {
        return doctorRating;
    }

    /**
     * set rating 
     * @param rating
     */
    public void setDoctorRating(int rating) {
        this.doctorRating = rating;
    }

    /**
     *get feedback notes
     * @return gets feedback as a string
     */
    public String getFeedbackNotes() {
        return feedbackNotes;
    }

    /**
     *set feedback by passing in a string
     * @param feedbackNotes
     */
    public void setFeedbackNotes(String feedbackNotes) {
        this.feedbackNotes = feedbackNotes;
    }

    /**
     * get dorctor Rating ID
     * @return doctorRatingID as a integer
     */
    public int getDoctorRatingID() {
        return doctorRatingID;
    }

    /**
     * setdoctor rating ID as a integer
     * @param doctorRatingID
     */
    public void setDoctorRatingID(int doctorRatingID) {
        this.doctorRatingID = doctorRatingID;
    }
    
    
    
}
