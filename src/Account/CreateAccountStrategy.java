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
public interface CreateAccountStrategy {
        public ModelsStore CreateAccount(ModelsStore models,UserModel user);
   
    
}
