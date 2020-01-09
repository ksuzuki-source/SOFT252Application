/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Serializer.WriteFile;
import Views.PatientUI;
import Appointment.AppointmentModel;
import Doctor.DoctorFeedback;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import Models.ModelsStore;
import Prescription.PrescriptionModel;
import UserModel.UserModel;

/**
 *
 * @author kouss
 */
public class PatientUIController {
       /**
     * This is were the view is stored
     */
    public PatientUI PatientView;

    /**
     * This is were the modelStore is stored
     */
    public ModelsStore modelStore;

    /**
     *This is were the writeFile is initialised
     */
    public WriteFile file = new WriteFile();
    
    /**
     * @param modelStore
     * @param UserID
     */
    public PatientUIController(ModelsStore modelStore, String UserID) {
        this.modelStore = modelStore;
        PatientView = new PatientUI();    
        PatientView.setVisible(true);
        PatientView.setPatientID(UserID);
        this.PatientView.setBtnPatientTerminate(new PatientUIController.PatientTerminateListener());
        this.PatientView.setBtnPatientViewAppointment(new PatientUIController.PatientViewAppointment() );
        this.PatientView.setBtnPatientViewPrescription(new PatientUIController.PatientViewPrescription());
        this.PatientView.setBtnPatientViewDoctor(new PatientUIController.PatientViewDoctors());
        this.PatientView.setBtnSaveFeedback(new PatientUIController.PatientSaveFeedback());
        this.PatientView.setBtnSubmitAppointment(new PatientUIController.PatientRequestAppointment());
//        this.PatientView.setBtnPatientHistory(new PatientUIController.PatientHistoryShow());
        setPatientAppointmentBox(UserID);
        setPatientPrescriptionBox(UserID);
        setDoctorBoxes();
        setPatientHistoryBox(UserID);
       
        
    }

    /**
     *Save the model to file
     * <p> calls the writeFile object to write the models to the file</p>
     */
    public void saveData(){
        file.executeAction(modelStore);
    } 
    private void setPatientAppointmentBox(String UserID){
        
        
        for (AppointmentModel ap : modelStore.AppointmentStore.getAppointments()) {
             if(ap.getPatientID().equals(UserID) && ap.isCompleted() == false){
                 PatientView.setBoxAppointment(ap.getDate().toString());
             }
        }

    }
    private void setPatientPrescriptionBox(String UserID){
                
        for (PrescriptionModel pr : modelStore.PrescriptionStore.getPrescriptions()) {
             if(pr.getPatient().equals(UserID)){
                 PatientView.setBoxPrescription(pr.getDatePrescriped().toString());
             }
        }

    }
    private void setDoctorBoxes(){
        
        for (UserModel dr : modelStore.DoctorStore.getUsers()) {
             PatientView.setBoxViewDoctors(dr.getUsername());
             PatientView.setBoxDoctors(dr.getUsername());
             PatientView.setBoxDoctorsAppoitment(dr.getUsername());
        }

    }
    private void setPatientHistoryBox(String UserID){
        // search for patient 
        
        
        for (AppointmentModel ap : modelStore.AppointmentStore.getAppointments()) {
             if(ap.getPatientID().equals(UserID) && ap.isCompleted()){
                 PatientView.setBoxHistory(ap.getDate().toString());
             }
        }
        //loop through appointment
        
        //set appointment
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    class PatientTerminateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String patientID = PatientView.getPatientID();
            if(patientID != null){
                //get patients
                for (UserModel p : modelStore.PatientStore.getUsers()){
                    //search for exact patient
                    if(p.getUsername().equals(patientID)){
                    //add new patient to terminate patient
                    modelStore.PatientAccountTerminationRequestStore.addUser(p);
                    }
                }
                saveData();
            }  
        }  
    }
    class PatientViewAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String AppointmentDate =  PatientView.getBoxAppointment();
           for (AppointmentModel ap : modelStore.AppointmentStore.getAppointments()) {
             if(ap.getPatientID().equals(PatientView.getPatientID())){
                 if (ap.getDate().toString().equals(AppointmentDate)) {
                     PatientView.setTxtInfo("Appointment Date: " + AppointmentDate
                             + "\nDoctor ID: " + ap.getDoctorID() + "\n"+
                             "Reason: " + ap.getReason());
                 } 
             }
        }
        }
        
    }
    class PatientViewPrescription implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String PrescriptionDate =  PatientView.getBoxPrescription();
           for (PrescriptionModel pr : modelStore.PrescriptionStore.getPrescriptions()) {
             if(pr.getPatient().equals(PatientView.getPatientID())){
                 if (pr.getDatePrescriped().toString().equals(PrescriptionDate)) {
                     String PrescriptionDay = PrescriptionDate;
                     PatientView.setTxtInfo( "Prescription Date: " + PrescriptionDay
                             + "\nDoctor ID: " + pr.getDoctor() + "\n"+
                             "Reason: " + pr.getNotes());
                     
                         PatientView.addTxtInfo("\nMedicine name: " + pr.getMedicine().getName() +
                                 "\nMedicine dosage: " + pr.getMedicine().getDosage() +
                                 "\nMedicine Quantity: " + pr.getMedicine().getQuantity());
                     
                 }
                 
             }
        }
        }
        
    }
    class PatientViewDoctors implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String doctor = PatientView.getBoxViewDoctors();
            float averageRating = 0;
            PatientView.setTxtInfo("Doctor: " + doctor);
            for(DoctorFeedback feedback : modelStore.DoctorFeedbackStore.getDoctorsFeedback()){
                if (feedback.getDoctorID().equals(doctor)) {
                    PatientView.addTxtInfo("\nRating: " + feedback.getDoctorRating() + "\nComments: " + feedback.getFeedbackNotes());
                    averageRating += feedback.getDoctorRating();
                }
                
            }
            averageRating = averageRating / modelStore.DoctorFeedbackStore.getDoctorsFeedback().size();
            PatientView.addTxtInfo("\nAverage Rating: " + averageRating);
            saveData();
        }
        
    }
    class PatientSaveFeedback implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int rating = Integer.parseInt(PatientView.getBoxRating());
            String feedback = PatientView.getTxtFeedback();
            String doctor = PatientView.getBoxDoctor();
            int ratingID = modelStore.DoctorFeedbackStore.getDoctorsFeedback().size();
            
            DoctorFeedback drFeedback = new DoctorFeedback(doctor,rating,feedback,ratingID);
            modelStore.DoctorFeedbackStore.addDoctorFeedback(drFeedback);
            PatientView.setTxtFeedback("");
            saveData();
        }
        
    }
    class PatientRequestAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
            
            String Date = PatientView.getDate(); 

            String doctor = PatientView.getBoxDoctorAppointment();
            String patientID = PatientView.getPatientID();
            int SizeOfAppoitments = modelStore.AppointmentStore.getAppointments().size() -1;
            int getAppointmentID = modelStore.AppointmentStore.getAppointments().get(SizeOfAppoitments).getAppointmentID() +1;
            AppointmentModel ap = new AppointmentModel(getAppointmentID, Date, doctor, patientID);
            modelStore.AppointmentRequestStore.addAppointment(ap);
            saveData();
            
        }
    class PatientHistoryShow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String AppointmentDate =  PatientView.getBoxAppointment();
           for (AppointmentModel ap : modelStore.AppointmentStore.getAppointments()) {
             if(ap.getPatientID().equals(PatientView.getPatientID())){
                     PatientView.setTxtInfo( "Appointment Date: " + AppointmentDate
                             + "\nDoctor ID: " + ap.getDoctorID() + "\n"+
                             "Reason: " + ap.getReason());
                 }
                 
             }
        }
        }
        
    }
    
}
