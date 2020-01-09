/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ModelsStore;
import UserModel.UserModel;
import Account.CreateAccount;
import Account.RequestAccount;
import Account.CreateAccountStrategy;
/**
 *
 * @author kouss
 */

public class LoginHandler  {

private CreateAccountStrategy createAccount;

    public LoginHandler() {
        
    }

    /**
     * @param createAccount
     */
    public void setStrategy(CreateAccountStrategy createAccount){
        this.createAccount = createAccount;
    }
    
    /**
     * @param models
     * @param user
     * @return the models once the account has been created
     */
    public ModelsStore createAccount(ModelsStore models,UserModel user){
        return createAccount.CreateAccount(models, user);
    }
    
}
