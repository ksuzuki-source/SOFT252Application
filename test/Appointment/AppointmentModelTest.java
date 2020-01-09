/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Appointment.AppointmentModel;
import Appointment.AppointmentStore;
import Appointment.AppointmentRequest;

/**
 *
 * @author kouss
 */
public class AppointmentModelTest {
    
    public AppointmentModelTest() {
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
    public void testGetDate() {
    }

    @Test
    public void testSetDate() {
    }

    @Test
    public void testGetDoctorID() {
    }

    @Test
    public void testSetDoctorID() {
    }

    @Test
    public void testGetPatientID() {
    }

    @Test
    public void testSetPatientID() {
    }

    @Test
    public void testGetReason() {
    }

    @Test
    public void testSetReason() {
    }

    @Test
    public void testGetAppointmentID() {
    }

    @Test
    public void testSetAppointmentID() {
    }

    @Test
    public void testGetNotes() {
    }

    @Test
    public void testSetNotes() {
    }

    @Test
    public void testIsCompleted() {
    }

    @Test
    public void testSetCompleted() {
    }
        @Test
    public void TestAppointmentsValues(){
        LocalDateTime now = LocalDateTime.now();
        AppointmentModel app = new AppointmentModel(0,"2/Dec","John","Steve");
        assertEquals("testing ID method", 0, app.getAppointmentID());
        assertEquals("testing doctor ID method","John",app.getDoctorID());
        assertEquals("testing PatientID method","Steve",app.getPatientID());
    }
    @Test
    public void TestAppointmentsStorage(){
        LocalDateTime now = LocalDateTime.now();
        AppointmentStore appointmentStore = new AppointmentStore();
        AppointmentModel app = new AppointmentModel(0,"2/Dec","John","Steve");
        appointmentStore.addAppointment(app);
        assertEquals("testing Adding appointment method",0,appointmentStore.getAppointments().get(0).getAppointmentID());
        //editing a appointment
        appointmentStore.getAppointments().get(0).setAppointmentID(1);
        assertEquals("Test if editing a appointment in storage works", 1, appointmentStore.getAppointments().get(0).getAppointmentID());
        //testing removing a user
        appointmentStore.removeAppointment(app);
        assertEquals("Test if remove function works", 0 , appointmentStore.getAppointments().size());
        
    }
    @Test
    public void TestPendingAppointmentsStorage(){
        LocalDateTime now = LocalDateTime.now();
        AppointmentRequest appointmentStore = new AppointmentRequest();
        AppointmentModel app = new AppointmentModel(0,"2/Dec","John","Steve");
        appointmentStore.addAppointment(app);
        assertEquals("testing Adding appointment method",0,appointmentStore.getAppointments().get(0).getAppointmentID());
        //editing a appointment
        appointmentStore.getAppointments().get(0).setAppointmentID(1);
        assertEquals("Test if editing a appointment in storage works", 1, appointmentStore.getAppointments().get(0).getAppointmentID());
        //testing removing a user
        appointmentStore.removeAppointment(app);
        assertEquals("Test if remove function works", 0 , appointmentStore.getAppointments().size());
        
    }
    
}
