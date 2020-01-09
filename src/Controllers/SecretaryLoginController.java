/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Serializer.WriteFile;
import Views.SecretaryLoginUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.ModelsStore;
import UserModel.UserModel;
import Controllers.SecretaryUIController;
/**
 *
 * @author kouss
 */
public class SecretaryLoginController {
    
        /**
     * sets up the authsecretaryview
     */
    public SecretaryLoginUI SecretaryLoginView;

    /**
     * sets up the modelStore
     */
    public ModelsStore modelStore;
    
    /**
     *Constructor for the Auth secretary Controller
     * @param modelStore
     */
    public SecretaryLoginController(ModelsStore modelStore) {
         
        this.modelStore = modelStore;
        SecretaryLoginView = new SecretaryLoginUI();    
        SecretaryLoginView.setVisible(true);
        this.SecretaryLoginView.setBtnSecretaryLoginListner(new SecretaryLoginController.SecretaryAuthRedirectListener());
    }
    class SecretaryAuthRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            
            String UserID = checkLogin(SecretaryLoginView.getUsername(),SecretaryLoginView.getPassword());
            if( UserID != null){
                SecretaryUIController LoginController= new SecretaryUIController(modelStore,UserID);   
                SecretaryLoginView.setVisible(false);
            }
            else{
                SecretaryLoginView.setTxtResponse("invalid username and/or password");
            }
        }
        public String checkLogin(String Username,String Password){

            for (UserModel p : modelStore.SecretaryStore.getUsers()){
                if(p.getUsername().equals(Username) && p.getPassword().equals(Password)){
                    return p.getUsername();
                }
            }
            return null;
        }
        
    }
    
}
