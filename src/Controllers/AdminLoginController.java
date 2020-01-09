/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Serializer.WriteFile;
import Administrator.AdministratorModel;
import Views.AdminLoginUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.ModelsStore;
import UserModel.UserModel;
import Controllers.AdminUIController;
import Account.CreateAccount;

/**
 *
 * @author kouss
 */
public class AdminLoginController extends LoginHandler {

    /**
     *sets up the view 
     */
    public AdminLoginUI AdminLoginView;

    /**
     * sets up the modelStore
     */
    public ModelsStore modelStore;

    /**
     * initialises the writeFile object
     */
    public WriteFile file = new WriteFile();
    
    /**
     * @param modelStore
     */
    public AdminLoginController(ModelsStore modelStore) {
        CreateAccount acc = new CreateAccount();
        setStrategy(acc);
        this.modelStore = modelStore;
        AdminLoginView = new AdminLoginUI();    
        AdminLoginView.setVisible(true);
        this.AdminLoginView.setBtnAdminLoginListner(new AdminLoginController.AdminLoginRedirectListener());
        this.AdminLoginView.setBtnAdminCreateAccountListener(new AdminLoginController.AdminCreateAccount());
    }
    class AdminLoginRedirectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String UserID = checkLogin(AdminLoginView.getUsername(),AdminLoginView.getPassword());
            if( UserID != null){
//                AdminUIController LoginController= new AdminUIController(modelStore, UserID);   
                AdminLoginView.setVisible(false);
            }
            else{
                AdminLoginView.setTxtResponse("invalid username and/or password");
            }
            
        }
        public String checkLogin(String Username,String Password){

            for (UserModel p : modelStore.AdminStore.getUsers()){
                if(p.getUsername().equals(Username) && p.getPassword().equals(Password)){
                    return p.getUsername();
                }
            }
            return null;
        }
        
    }
    class AdminCreateAccount implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = AdminLoginView.getTxtUsernameReg();
            String password = AdminLoginView.getTxtPasswordReg();
            String firstname = AdminLoginView.getTxtFirstnameReg();
            String surname = AdminLoginView.getTxtSurnameReg();
            String address = AdminLoginView.getTxtAddressReg();
            
            AdministratorModel admin = new AdministratorModel(username,password,firstname,surname,address);
            modelStore.AdminStore.addUser(admin);
            AdminLoginView.setTxtResponseReg("Account create Sucessfully");
            file.executeAction(modelStore);
            AdminLoginView.setTxtPasswordReg("Created Admin Account");
        }
        
    }
}
