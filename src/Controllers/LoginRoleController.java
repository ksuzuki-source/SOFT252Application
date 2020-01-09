/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.event.ActionListener;
import Controllers.AdminLoginController;
import Controllers.DoctorLoginController;
import Controllers.PatientLoginCointroller;
import Controllers.SecretaryLoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.ModelsStore;
import Views.LoginRole;

/**
 *
 * @author kouss
 */
public class LoginRoleController    {


    /**
     *This is were the userchoice view is stored
     */
    public LoginRole gui;
    //User models

    /**
     * The models are stored here
     */
    public ModelsStore modelStore;

   public LoginRoleController(ModelsStore modelsStore) {
        
        this.modelStore = modelStore;
        gui = new LoginRole();    
        gui.setVisible(true);
        this.gui.setBtnAdminListner(new AdminRedirectListener());
        this.gui.setBtnPatientListner(new PatientRedirectListener());
        this.gui.setBtnDoctorListner(new DoctorRedirectListener());
        this.gui.setBtnSecretaryListner(new SecretaryRedirectListener());
    }

    class AdminRedirectListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
            AdminLoginController LoginController= new AdminLoginController(modelStore);   
            gui.setVisible(false);
        }
        
    }
    class DoctorRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            DoctorLoginController LoginController= new DoctorLoginController(modelStore);   
            gui.setVisible(false);
        }
        
    }
    class PatientRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            PatientLoginCointroller LoginController= new PatientLoginCointroller(modelStore);   
            gui.setVisible(false);
        }
        
    }
    class SecretaryRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            SecretaryLoginController LoginController= new SecretaryLoginController(modelStore);   
            gui.setVisible(false);
        }
        
    }
    
    
}
