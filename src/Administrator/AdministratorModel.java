/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import java.io.Serializable;
import UserModel.UserModel;
/**
 *
 * @author kouss
 */
public class AdministratorModel  extends UserModel {

    public AdministratorModel(){
    }
    
    /**
     * @param username
     * @param password
     * @param firstName
     * @param surname
     * @param address
     */
    public AdministratorModel(String username, String password, String firstName, String surname, String address) {
        super(username, password, firstName, surname, address);
    }
}
    

