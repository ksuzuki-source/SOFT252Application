/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.DoctorLoginUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.ModelsStore;
import UserModel.UserModel;
import Controllers.DoctorUIController;
import java.util.ArrayList;


/**
 *
 * @author kouss
 */
public class DoctorLoginController {
    
    
     public DoctorLoginUI DoctorLoginView;

    /**
     * sets up the modelStore
     */
    public ModelsStore modelStore;
    
    /**
     *Constructor for authDoctorController
     * <p> sets up the modelStore and the view</p>
     * <p> sets up the onclicks for the doctorView </p>
     * @param modelStore
     */
    public DoctorLoginController(ModelsStore modelStore) {
        this.modelStore = modelStore; 
        DoctorLoginView = new DoctorLoginUI();    
        DoctorLoginView.setVisible(true);
        //this.AuthPatientView.setBtnListner(new AuthPatientController.RedirectListener());
        this.DoctorLoginView.setBtnDoctorLoginListner(new DoctorLoginController.DoctorAuthRedirectListener());
    }
    
    
    class DoctorAuthRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String UserID = checkLogin(DoctorLoginView.getUsername(),DoctorLoginView.getPassword());
            if( UserID != null){
                DoctorUIController LoginController= new DoctorUIController(modelStore,UserID);   
                DoctorLoginView.setVisible(false);
                LoginController.setVisible(true);
            }
            else{
                DoctorLoginView.setTxtResponse("invalid username and/or password");
            }
        }
        public String checkLogin(String Username,String Password){

            for (UserModel p :(ArrayList<UserModel>) modelStore.DoctorStore.getUsers()){
                if(p.getUsername().equals(Username) && p.getPassword().equals(Password)){
                    return p.getUsername();
                }
            }
            return null;
        }
        
    }
    
}
