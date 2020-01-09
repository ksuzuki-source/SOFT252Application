/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kouss
 */
public class PatientModelTest {
    
    public PatientModelTest() {
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
    public void testGetAge() {
    }

    @Test
    public void testSetAge() {
    }

    @Test
    public void testGetSex() {
    }

    @Test
    public void testSetSex() {
    }
    
    @Test
    public void TestPatientAttributes(){
        PatientModel person = new PatientModel(20,"male","person123", "password", "firstname", "surname","25 a place");
        assertEquals("testing age method", 20, person.getAge());
        assertEquals("testing gender method", "male", person.getSex());
        assertEquals("testing username method", "person123", person.getUsername());
        assertEquals("testing password method","password",person.getPassword());
        assertEquals("testing firstname method","firstname",person.getFirstName());
        assertEquals("testing surname method","surname",person.getSurname());
        assertEquals("testing address method","25 a place",person.getAddress());
    }
    @Test
    public void TestPatientStorage(){
        PatientModel person = new PatientModel(20,"male","person123", "password", "firstname", "surname","25 a place");
        PatientStore patientStore = new PatientStore();
        patientStore.addUser(person);
        person = (PatientModel) patientStore.findUser(person);
        assertEquals("testing if can cast and get back the sex","male",person.getSex());
    }
    
    @Test
    public void TestPatientStorageTerminate(){
        PatientModel person = new PatientModel(20,"male","person123", "password", "firstname", "surname","25 a place");
        PatientAccountTerminationRequest pendingTerminatePatientAccounts = new PatientAccountTerminationRequest();
        pendingTerminatePatientAccounts.addUser(person);
        person = (PatientModel) pendingTerminatePatientAccounts.findUser(person);
        assertEquals("testing if can cast and get back the sex","male",person.getSex());
    }
}
