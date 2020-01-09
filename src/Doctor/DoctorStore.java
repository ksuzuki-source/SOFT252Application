/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import java.io.Serializable;
import java.util.ArrayList;
import UserModel.UserModel;
import UserModel.IUserManagement;

/**
 *
 * @author kouss
 */
public class DoctorStore implements IUserManagement , Serializable{
    ArrayList<UserModel> doctors = new ArrayList<>();

    /**
     * Constructor to set up doctorStorage
     */
    public DoctorStore() {
    }

    @Override
    public void addUser(UserModel user) {
        this.doctors.add(user);
    }

    @Override
    public void removeUser(UserModel user) {
        this.doctors.remove(user);
    }

    @Override
    public UserModel findUser(UserModel user) {
        int index = this.doctors.indexOf(user);
        return this.doctors.get(index);
    }

    @Override
    public ArrayList<UserModel> getUsers() {
        return this.doctors;
    }
}
