/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import Models.ModelsStore;
import UserModel.UserModel;

/**
 *
 * @author kouss
 */
public class CreateAccount implements CreateAccountStrategy {

    /**
     * strategy to create an account
     * <p> adds a user to adminstore </p>
     * @param models
     * @param user
     * @return the updated models with the new admin 
     */
    @Override
    public ModelsStore CreateAccount(ModelsStore models, UserModel user) {
        models.AdminStore.addUser(user);
        return models;       
    }


}
