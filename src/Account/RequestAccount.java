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
public class RequestAccount implements CreateAccountStrategy {

    /**
     *Creates a pending account for a patient
     * <p> adds a patient user to the pending accounts store</p>
     * @param models
     * @param user
     * @return the updated modelStore with new patient inside
     */
    @Override
    public ModelsStore CreateAccount(ModelsStore models, UserModel user) {
        models.AccountsRequestStore.addUser(user);
        return models;
    }
    
}
