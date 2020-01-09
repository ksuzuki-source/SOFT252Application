/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import java.util.ArrayList;

/**
 *
 * @author kouss
 */
public interface IUserManagement {
    /**
     * adds user abstract implementation
     * @param user
     */
    public void addUser(UserModel user);

    /**
     * remove user abstract implementation
     * @param user
     */
    public void removeUser(UserModel user);

    /**
     * finds user abstract implementation
     * @param user
     * @return a user object
     */
    public UserModel findUser(UserModel user);

    /**
     * gets the users
     * @return a array list of users
     */
    public ArrayList<UserModel> getUsers();
}
