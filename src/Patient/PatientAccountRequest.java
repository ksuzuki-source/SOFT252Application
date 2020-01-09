/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;

import java.io.Serializable;
import java.util.ArrayList;
import UserModel.UserModel;
import UserModel.IUserManagement;

/**
 *
 * @author kouss
 */
public class PatientAccountRequest implements IUserManagement , Serializable{
    ArrayList<PatientModel> patients= new ArrayList<>();

    
    public PatientAccountRequest() {
    }

    @Override
    public void addUser(UserModel user) {
           this.patients.add((PatientModel) user);
    }

    @Override
    public void removeUser(UserModel user) {
        this.patients.remove((PatientModel) user);
    }

    @Override
    public UserModel findUser(UserModel user) {
        int index = this.patients.indexOf(user);
        return this.patients.get(index);
    }

    @Override
    public ArrayList<UserModel> getUsers() {
        ArrayList<UserModel> tempUser = new ArrayList<>();
        for (int i = 0; i < this.patients.size(); i++) {
            tempUser.add(this.patients.get(i));
	}
        return tempUser;
    }
    
}
