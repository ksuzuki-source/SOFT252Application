/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secretary;

import java.io.Serializable;
import UserModel.UserModel;

/**
 *
 * @author kouss
 */

public class SecretaryModel extends UserModel implements Serializable{

    public SecretaryModel(){
        
    }

    /**
     * constructor that calls the super user constructor
     * @param username
     * @param password
     * @param firstName
     * @param surname
     * @param address
     */
    public SecretaryModel(String username, String password, String firstName, String surname, String address) {
        super(username, password, firstName, surname, address);
    }
    
}
