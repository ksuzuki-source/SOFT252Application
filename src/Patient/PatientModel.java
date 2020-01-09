/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;

import java.io.Serializable;
import UserModel.UserModel;

/**
 *
 * @author kouss
 */

public class PatientModel extends UserModel implements IPatientDetail , Serializable{
    private int age;
    private String sex;
    

    public PatientModel(){
        
    }

    /**
     * constructor that calls the super user class then adds age and sex to the constructor
     * @param age
     * @param sex
     * @param username
     * @param password
     * @param firstName
     * @param surname
     * @param address
     */
    public PatientModel(int age, String sex, String username, String password, String firstName, String surname, String address) {
        super(username, password, firstName, surname, address);
        this.age = age;
        this.sex = sex;
    }

    /**
     * get age
     * @return gets age as an integer
     */
    @Override
    public int getAge() {
        return age;
    }

    /**
     * sets age as an integer
     * @param age
     */
    @Override
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * gets sex
     * @return gets sex as a String
     */
    @Override
    public String getSex() {
        return sex;
    }

    /**
     *sets sex as a string
     * @param sex
     */
    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }
    
}
