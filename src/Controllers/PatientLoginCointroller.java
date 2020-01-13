/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Serializer.WriteFile;
import Views.PatientLoginUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.ModelsStore;
import Patient.PatientModel;
import UserModel.UserModel;
import Account.RequestAccount;
import java.util.ArrayList;
/**
 *
 * @author kouss
 */
public class PatientLoginCointroller extends LoginHandler {

    /**
     *sets up the Loginview 
     */
    public PatientLoginUI PatientLoginView;

    /**
     * sets up the modelStore
     */
    public ModelsStore modelStore;

    /**
     * sets up the writeFile object
     */
    public WriteFile file = new WriteFile();

    /**
     * @param modelStore
     */
    public PatientLoginCointroller( ModelsStore modelStore) {
        RequestAccount acc = new RequestAccount();
        setStrategy(acc);
        this.modelStore = modelStore;
        this.modelStore = modelStore;
        PatientLoginView = new PatientLoginUI();    
        PatientLoginView.setVisible(true);
        this.PatientLoginView.setBtnPatientLoginListner(new PatientLoginCointroller.PatientLoginRedirectListener());
        this.PatientLoginView.setBtnPatientRegister(new PatientLoginCointroller.RegisterPatientListener());
    }
    
    
    
    class PatientLoginRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String UserID = checkLogin(PatientLoginView.getUsername(),PatientLoginView.getPassword());
            if( UserID != null){
                PatientUIController LoginController= new PatientUIController(modelStore, UserID);   
                PatientLoginView.setVisible(false);
                LoginController.setVisible(true);
            }
            else{
                PatientLoginView.setTxtResponse("invalid username and/or password");
            }
        }
        public String checkLogin(String Username,String Password){
            for (UserModel p :(ArrayList<UserModel>) modelStore.PatientStore.getUsers()){
                if(p.getUsername().equals(Username) && p.getPassword().equals(Password)){
                    return p.getUsername();
                }
            }
            return null;
        }
        
    }
    class RegisterPatientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = PatientLoginView.getTxtUsernameReg();
            String password = PatientLoginView.getTxtPasswordReg();
            String firstname = PatientLoginView.getTxtFirstnameReg();
            String surname = PatientLoginView.getTxtSurnameReg();
            String address = PatientLoginView.getTxtAddressReg();
            int age = Integer.parseInt(PatientLoginView.getTxtAgeReg());
            String gender = PatientLoginView.getTxtGenderReg();
            PatientModel tempPatient = new PatientModel(age,gender,username,password,firstname
            ,surname,address);
            modelStore = createAccount(modelStore,tempPatient);
            file.executeAction(modelStore);
            PatientLoginView.setTxtResponseReg("Created Account");
        }
        
    }
}
