/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secretary;

import Doctor.DoctorModel;
import Doctor.DoctorStore;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Secretary.SecretaryModel;
import Secretary.SecretaryStore;

/**
 *
 * @author kouss
 */
public class SecretaryModelTest {
    
    public SecretaryModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

      @Test
    public void testSomeMethod() {

        DoctorModel person = new DoctorModel("Doctor111", "password", "firstname", "surname","Whereever");
        assertEquals("testing username method", "Doctor111", person.getUsername());
        assertEquals("testing password method","password",person.getPassword());
        assertEquals("testing firstname method","firstname",person.getFirstName());
        assertEquals("testing surname method","surname",person.getSurname());
        assertEquals("testing address method","Whereever",person.getAddress());
    }
    @Test
    public void TestDoctorStorage(){
        //testing adding a person
        DoctorModel person = new DoctorModel("person123", "password", "firstname", "surname","Whereever");
        DoctorStore doctorStore = new DoctorStore();
        doctorStore.addUser(person);
        assertEquals("Test if admin in storage", "person123", doctorStore.getUsers().get(0).getUsername());
        //test editing a user
        doctorStore.getUsers().get(0).setUsername("james");
        assertEquals("Test if editing a admin in storage works", "james", doctorStore.getUsers().get(0).getUsername());
        //testing removing a user
        doctorStore.removeUser(person);
        assertEquals("Test if remove function works", 0 , doctorStore.getUsers().size());
        
        
    }
}
