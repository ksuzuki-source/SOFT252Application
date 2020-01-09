/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secretary;

import java.io.Serializable;
import java.util.ArrayList;
import UserModel.UserModel;
import UserModel.IUserManagement;

/**
 *
 * @author kouss
 */
public class SecretaryStore implements IUserManagement , Serializable{
    ArrayList<UserModel> secretaries = new ArrayList<>();

    /**
     * constructor to set up secretary storage
     */
    public SecretaryStore() {
    }

    @Override
    public void addUser(UserModel user) {
        this.secretaries.add(user);
    }

    @Override
    public void removeUser(UserModel user) {
        this.secretaries.remove(user);
    }

    @Override
    public UserModel findUser(UserModel user) {
        int index = this.secretaries.indexOf(user);
        return this.secretaries.get(index);
    }

    @Override
    public ArrayList<UserModel> getUsers() {
        return this.secretaries;
    }
    
}
