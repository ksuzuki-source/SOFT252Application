/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Serializer.WriteFile;
import Views.AdminUI;
import Doctor.DoctorModel;
import Doctor.DoctorFeedback;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Models.ModelsStore;
import Secretary.SecretaryModel;
import UserModel.UserModel;

/**
 *
 * @author kouss
 */
public class AdminUIController {
      /**
     * The view stored in the admin view
     */
    public AdminUI AdminView;

    /**
     * Models stored in this class 
     */
    public ModelsStore modelStore;

    /**
     * Initialise the writeFile class
     */
    public WriteFile file = new WriteFile();

    /**
     *The constructor to set up the controller
     * <p> The constructor sets up the view</p>
     * <p> The constructor sets up the data on screen 
     *  such as the on clicks and user lists </p>
     * @param modelStore
     */
    public AdminUIController(ModelsStore modelStore) {
        this.modelStore = modelStore;
        AdminView = new AdminUI();
        AdminView.setVisible(true);
        //AdminView.setTxtAdminID(UserID);
        setUpOnClicks();
        setDoctorsList();
        setSecretaryList();
    }
    
    private void setUpOnClicks(){
        this.AdminView.btnAddUser(new AdminUIController.AddUser());
        this.AdminView.btnRemoveUser(new AdminUIController.RemoveUser());
        this.AdminView.listDoctorClick(new AdminUIController.ShowDoctorUser());
        this.AdminView.listSecretaryClick(new AdminUIController.ShowSecretaryUser());
        this.AdminView.listDoctorRatingClick(new AdminUIController.ShowFeedbackAndRatings());
        this.AdminView.listDoctorFeedbackClick(new AdminUIController.ShowFeedbackForDoctor());
        this.AdminView.btnSubmitFeedback(new AdminUIController.SubmitFeedback());
    }

    private void setDoctorsList() {
        int amntOfDocs = modelStore.DoctorStore.getUsers().size();

        String[] doctors = new String[amntOfDocs];
        for (int i = 0; i < amntOfDocs; i++) {
            doctors[i] = modelStore.DoctorStore.getUsers().get(i).getUsername();
        }
        AdminView.setListDoctors(doctors);
    }

    private void setSecretaryList() {
        int amntOfSecretaries = modelStore.SecretaryStore.getUsers().size();

        String[] secretaries = new String[amntOfSecretaries];
        for (int i = 0; i < amntOfSecretaries; i++) {
            secretaries[i] = modelStore.SecretaryStore.getUsers().get(i).getUsername();
        }
        AdminView.setListSecretary(secretaries);
    }

    /**
     * Method that calls the writeFile object
     * <p> This calls the method to write the models to the json file </p>
     */
    public void saveData(){
        file.executeAction(modelStore);
    } 
    class AddUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String user = AdminView.getTxtUser();
            String username = AdminView.getTxtUsername();
            String password = AdminView.getTxtPassword();
            String firstname = AdminView.getTxtFirstname();
            String surname = AdminView.getTxtLastname();
            String address = AdminView.getTxtAddress();
            
            if (user.equals("Secretary")) {
                SecretaryModel sec = new SecretaryModel(username,password,firstname,surname,address);
                modelStore.SecretaryStore.addUser(sec);
                
            }
            else if(user.equals("Doctor")){
                DoctorModel ad = new DoctorModel(username,password,firstname,surname,address);
                modelStore.DoctorStore.addUser(ad);
            }
            setDoctorsList();
            setSecretaryList();
            AdminView.deselectSecretary();
            AdminView.deselectDoctor();
            saveData();
            
        }

    }

    class RemoveUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String user = AdminView.getTxtUser();
            String username = AdminView.getTxtUsername();
            if (user.equals("Secretary")) {
                for(UserModel sec : modelStore.SecretaryStore.getUsers()){
                    if(sec.getUsername().equals(username)){
                        modelStore.SecretaryStore.removeUser(sec);
                        break;
                    }
                }  
            }
            
            else if(user.equals("Doctor")){
                for(UserModel dr : modelStore.DoctorStore.getUsers()){
                    if(dr.getUsername().equals(username)){
                        modelStore.DoctorStore.removeUser(dr);
                        break;
                    }
                }
            }
            setDoctorsList();
            setSecretaryList();
            AdminView.deselectSecretary();
            AdminView.deselectDoctor();
            saveData();
        }

    }

    class ShowDoctorUser implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String doctor = AdminView.getListDoctor();
            for (UserModel dr : modelStore.DoctorStore.getUsers()) {
                if (dr.getUsername().equals(doctor)) {
                    AdminView.setTxtUser("Doctor");
                    AdminView.setTxtUsername(doctor);
                    AdminView.setTxtPassword(dr.getPassword());
                    AdminView.setTxtFirstname(dr.getFirstName());
                    AdminView.setTxtLastname(dr.getSurname());
                    AdminView.setTxtAddress(dr.getAddress());
                    AdminView.deselectSecretary();
                }
            }
            AdminView.selectDoctorRad();
            saveData();
        }

    }

    class ShowSecretaryUser implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String secretary = AdminView.getListSecretary();
            for (UserModel sec : modelStore.SecretaryStore.getUsers()) {
                if (sec.getUsername().equals(secretary)) {
                    AdminView.setTxtUser("Secretary");
                    AdminView.setTxtUsername(secretary);
                    AdminView.setTxtPassword(sec.getPassword());
                    AdminView.setTxtFirstname(sec.getFirstName());
                    AdminView.setTxtLastname(sec.getSurname());
                    AdminView.setTxtAddress(sec.getAddress());
                    AdminView.deselectDoctor();
                }
            }
            AdminView.selectSecretaryRad();
            saveData();
        }

    }
    class ShowFeedbackAndRatings implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            //showing ratings
            String doctor = AdminView.getListRatingDoctor();
            float averageRating = 0;
            AdminView.setTxtInfo("Doctor: " + doctor);
            for(DoctorFeedback feedback : modelStore.DoctorFeedbackStore.getDoctorsFeedback()){
                if (feedback.getDoctorID().equals(doctor)) {
                    AdminView.addTxtInfo("\nRating: " + feedback.getDoctorRating() + "\nComments: " + feedback.getFeedbackNotes());
                    averageRating += feedback.getDoctorRating();
                }
                
            }
            averageRating = averageRating / modelStore.DoctorFeedbackStore.getDoctorsFeedback().size();
            AdminView.addTxtInfo("\nAverage Rating: " + averageRating);
            

            int lengthofFeedback = modelStore.DoctorFeedbackStore.getDoctorsFeedback().size();
            String[] feedback = new String[lengthofFeedback];
            for (int i = 0; i < lengthofFeedback; i++) {
                if (modelStore.DoctorFeedbackStore.getDoctorsFeedback().get(i).getDoctorID().equals(doctor)) {
                    feedback[i] = Integer.toString(modelStore.DoctorFeedbackStore.getDoctorsFeedback().get(i).getDoctorRatingID());
                }
                
            }
            AdminView.setListFeedback(feedback);
            saveData();
            
        }
        
        
    }
    class ShowFeedbackForDoctor implements ListSelectionListener{

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (AdminView.getListFeedback() != null) {
                    int ratingID = Integer.parseInt(AdminView.getListFeedback());
                
                for (DoctorFeedback feed : modelStore.DoctorFeedbackStore.getDoctorsFeedback()) {
                    if (feed.getDoctorRatingID() == ratingID) {
                        AdminView.setSlideRating(feed.getDoctorRatingID());
                        AdminView.setTxtFeedback(feed.getFeedbackNotes());
                    }                                                     
                }
                saveData();
                }
                
                
            }
            
    }
    class SubmitFeedback implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String doctor = AdminView.getListRatingDoctor();
            int ratingID = Integer.parseInt(AdminView.getListFeedback());
            int rating = AdminView.getSlideRating();
            String message = AdminView.getTxtFeedback();
      
            DoctorFeedback feedback = new DoctorFeedback(doctor,rating,message,ratingID);
            modelStore.DoctorFeedbackStore.addDoctorFeedback(feedback);

            for (DoctorFeedback feed : modelStore.DoctorFeedbackStore.getDoctorsFeedback()) {
                    if (feed.getDoctorRatingID() == ratingID) {
                        modelStore.DoctorFeedbackStore.getDoctorsFeedback().remove(feed);
                        break;
                    }                                                     
            }
            //refresh all the assets on screen
            AdminView.clearAllforFeedback();
            setDoctorsList();
            saveData();
            
        }
        
    }
    
}
