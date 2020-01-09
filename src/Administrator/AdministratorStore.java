/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import java.io.Serializable;
import java.util.ArrayList;
import UserModel.UserModel;
import UserModel.IUserManagement;

/**
 *
 * @author kouss
 */
public class AdministratorStore implements IUserManagement   {
    ArrayList<UserModel> admins = new ArrayList<>();

    /**
     * Default constructor so can read from the json file
     */
    public AdministratorStore() {
    }

    /**
     * Adds a admin object to this class
     * @param user
     */
    @Override
    public void addUser(UserModel user) {
        this.admins.add(user);
    }

    /**
     * removes a admin object by passing in a user object
     * @param user
     */
    @Override
    public void removeUser(UserModel user) {
        this.admins.remove(user);
    }

    /**
     * Finds an admin by passing in a user object
     * @param user
     * @return the index of the object 
     */
    @Override
    public UserModel findUser(UserModel user) {
        int index = this.admins.indexOf(user);
        return this.admins.get(index);
    }

    /**
     * gets the array list of admins
     * @return the Array list of objects Admins
     */
    @Override
    public ArrayList<UserModel> getUsers() {
        return this.admins;
    }
    
}
