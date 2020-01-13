/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import java.io.Serializable;

/**
 *
 * @author kouss
 */
public class UserModel implements Serializable{
    
    /**
     *Store the id for the user
     */
    protected String username;

    /**
     * the password for each user
     */
    protected String password;

    /**
     * The users firstname
     */
    protected String firstName;

    /**
     * The users surname
     */
    protected String surname;

    /**
     * The users address 
     */
    protected String address;

    /**
     * default constructor not used except for reading from the json file
     */
    public UserModel(){
        
    }
    
    /**
     * Constructor that initialises the attributes
     * @param username
     * @param password
     * @param firstName
     * @param surname
     * @param address
     */
    public UserModel(String username, String password, String firstName, String surname, String address) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
    }

    /**
     * get username
     * @return the username 
     */
    public String getUsername() {
        return username;
    }

    /**
     *set username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get password
     * @return  password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *get firstname 
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *set firstname
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     *gets the surname
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * sets the surname
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * gets the address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets the address 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    
    
}
