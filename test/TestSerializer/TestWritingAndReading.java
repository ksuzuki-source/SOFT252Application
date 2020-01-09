/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSerializer;

import SerializerMock.ReadFile;
import SerializerMock.WriteFile;
import Administrator.AdministratorModel;
import Administrator.AdministratorStore;
import Appointment.AppointmentModel;
import Appointment.AppointmentStore;
import Appointment.AppointmentRequest;
import Doctor.DoctorModel;
import Doctor.DoctorFeedback;
import Doctor.DoctorFeedbackStore;
import Doctor.DoctorStore;
import java.time.LocalDateTime;
import Models.ModelsStore;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Patient.PatientModel;
import Patient.PatientStore;
import Patient.PatientAccountRequest;
import Patient.PatientAccountTerminationRequest;
import Prescription.MedicineModel;
import Prescription.MedicineStore;
import Prescription.PrescriptionModel;
import Prescription.PrescriptionStore;

import Secretary.SecretaryModel;
import Secretary.SecretaryStore;
import UserModel.UserModel;

/**
 *
 * @author kouss
 */
public class TestWritingAndReading {
    private ModelsStore modelStore;
    private ModelsStore ReadFilestore;
    
    public TestWritingAndReading() {
        PatientModel patient1 = new PatientModel(54,"male","Steve", "password", "Steve", "stephens","pl5 423a");
            PatientModel patient2 = new PatientModel(21,"female","Ellie", "aPassword", "Ellie", "Matthews","pl4 32a");
            PatientModel patient3  = new PatientModel(22,"male","Ryan", "bestPassword", "Ryan", "Harvey","pl6 e12");
            
            PatientStore patientStore = new PatientStore();
            
            patientStore.addUser(patient1);
            patientStore.addUser(patient2);
            patientStore.addUser(patient3);
            
            DoctorStore doctorStore = new DoctorStore();
            DoctorModel james = new DoctorModel("John", "password", "John","smith","pl5 4as");
            DoctorModel sam = new DoctorModel("Sam", "topSecret", "Sam","Hunt","pl34 23a");
            DoctorModel jill = new DoctorModel("Jill", "Banana1", "Jill","Hunt","pl34 23a");
            doctorStore.addUser(james);
            doctorStore.addUser(sam);
            doctorStore.addUser(jill);
            
            AdministratorModel admin1 = new AdministratorModel("Paul", "password", "Paul", "Santos","pl65 23");
            AdministratorStore adminStore = new AdministratorStore();
            adminStore.addUser(admin1);
            
            SecretaryModel sec1 = new SecretaryModel("Terry", "password", "Terry","Wells","pl45 ase");
            SecretaryStore secretaryStore = new SecretaryStore();
            secretaryStore.addUser(sec1);
//            
//            
            PrescriptionStore prescriptionStore = new PrescriptionStore();
            
            MedicineModel med = new MedicineModel("paracemtol", 20 , "2 a day");
            PrescriptionModel pre = new PrescriptionModel( 0 ,"Steve","John","","9/Dec",med);
//        pre.addMedicine(med);
            prescriptionStore.addPrescription(pre);

            MedicineModel med1 = new MedicineModel("paracemtol", 19);
            MedicineModel med2 = new MedicineModel("Solcicsola", 100 );
            MedicineModel med3 = new MedicineModel("Naxfloxal", 60 );
            MedicineModel med4 = new MedicineModel("Nitradexobo", 120 );
            MedicineModel med5 = new MedicineModel("Hobix", 19 );
            MedicineModel med6 = new MedicineModel("Enthsol", 19 );
            MedicineModel med7= new MedicineModel("Ectiridril", 19 );
            MedicineModel med8 = new MedicineModel("Anthcinui", 19 );
            MedicineModel med9 = new MedicineModel("Ganfloxart", 19 );
            MedicineModel med10 = new MedicineModel("Lincilagro", 19 );
            
            
            MedicineStore medicineStore = new MedicineStore();
            medicineStore.addMedicine(med1);
            medicineStore.addMedicine(med2);
            medicineStore.addMedicine(med3);
            medicineStore.addMedicine(med4);
            medicineStore.addMedicine(med5);
            medicineStore.addMedicine(med6);
            medicineStore.addMedicine(med7);
            medicineStore.addMedicine(med8);
            medicineStore.addMedicine(med9);
            medicineStore.addMedicine(med10);
            

            DoctorFeedbackStore doctorFeedbackStore = new DoctorFeedbackStore();
            DoctorFeedback feedback1 = new DoctorFeedback("John",4,"good doctor but is very busy",1);
            doctorFeedbackStore.addDoctorFeedback(feedback1);
            DoctorFeedback feedback2 = new DoctorFeedback("John",3,"good doctor but is very busy",2);
            doctorFeedbackStore.addDoctorFeedback(feedback2);


            AppointmentStore appointmentStore = new AppointmentStore();
            AppointmentModel app = new AppointmentModel(0,"02/Jan","John","Steve");
            AppointmentModel app4 = new AppointmentModel(1,"06/Dec","John","Steve");
            app.setCompleted(true);
            appointmentStore.addAppointment(app);
            appointmentStore.addAppointment(app4);

            AppointmentRequest pendingAppointmentsStore = new AppointmentRequest();
            AppointmentModel app1 = new AppointmentModel(0,"02/Jan","John","Steve");
            AppointmentModel app2 = new AppointmentModel(1,"06/Dec","sam","Steve");
            pendingAppointmentsStore.addAppointment(app1);
            pendingAppointmentsStore.addAppointment(app2);

            PatientAccountRequest pendingAccountsStore = new PatientAccountRequest();
            PatientModel patient4  = new PatientModel(22,"female","Emilee", "password", "Emilee", "Esparza","25 a place");
            PatientModel patient5  = new PatientModel(44,"male","Milo", "password", "Milo", "Goodman","25 a place");
            pendingAccountsStore.addUser(patient4);
            pendingAccountsStore.addUser(patient5);

            PatientAccountTerminationRequest pendingTerminateAccountsStore = new PatientAccountTerminationRequest();
            pendingTerminateAccountsStore.addUser(patient1);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        WriteFile files = new WriteFile();
           files.executeAction(modelStore);
           
           ModelsStore temp = null;         
           ReadFile file = new ReadFile();
           ModelsStore store = file.executeAction(temp);
           this.ReadFilestore = store;
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void TestPatientAfterFileRead() {
         int patientNumber = 0;
         for (UserModel pat: ReadFilestore.PatientStore.getUsers()) {
             assertTrue("test if the patient Username is the same", pat.getUsername().equals(modelStore.PatientStore.getUsers().get(patientNumber).getUsername()));
             assertTrue("test if the patient password is the same", pat.getPassword().equals(modelStore.PatientStore.getUsers().get(patientNumber).getPassword()));
             assertTrue("test if the patient firstname is the same", pat.getFirstName().equals(modelStore.PatientStore.getUsers().get(patientNumber).getFirstName()));
             assertTrue("test if the patient surname is the same", pat.getSurname().equals(modelStore.PatientStore.getUsers().get(patientNumber).getSurname()));
             assertTrue("test if the patient address is the same", pat.getAddress().equals(modelStore.PatientStore.getUsers().get(patientNumber).getAddress()));
             PatientModel tempPat = (PatientModel) modelStore.PatientStore.getUsers().get(patientNumber);
             PatientModel tempPatFromFile = (PatientModel) pat;
             assertTrue("test if the patient gender is the same", tempPat.getSex().equals(tempPatFromFile.getSex()));
             assertTrue("test if the patient age is the same", tempPat.getAge() == (tempPatFromFile.getAge()));
             patientNumber +=1;
         }
    
     }
     @Test
     public void TestPendingPatientAfterFileRead() {
         int patientNumber = 0;
         for (UserModel pat: ReadFilestore.AccountsRequestStore.getUsers()) {
             assertTrue("test if the patient Username is the same", pat.getUsername().equals(modelStore.AccountsRequestStore.getUsers().get(patientNumber).getUsername()));
             assertTrue("test if the patient password is the same", pat.getPassword().equals(modelStore.AccountsRequestStore.getUsers().get(patientNumber).getPassword()));
             assertTrue("test if the patient firstname is the same", pat.getFirstName().equals(modelStore.AccountsRequestStore.getUsers().get(patientNumber).getFirstName()));
             assertTrue("test if the patient surname is the same", pat.getSurname().equals(modelStore.AccountsRequestStore.getUsers().get(patientNumber).getSurname()));
             assertTrue("test if the patient address is the same", pat.getAddress().equals(modelStore.AccountsRequestStore.getUsers().get(patientNumber).getAddress()));
             PatientModel tempPat = (PatientModel) modelStore.AccountsRequestStore.getUsers().get(patientNumber);
             PatientModel tempPatFromFile = (PatientModel) pat;
             assertTrue("test if the patient gender is the same", tempPat.getSex().equals(tempPatFromFile.getSex()));
             assertTrue("test if the patient age is the same", tempPat.getAge() == (tempPatFromFile.getAge()));
             patientNumber +=1;
         }
    
     }
     @Test
     public void TestPendingTerminatePatientAfterFileRead() {
         int patientNumber = 0;
         for (UserModel pat: ReadFilestore.PatientAccountTerminationRequestStore.getUsers()) {
             assertTrue("test if the patient Username is the same", pat.getUsername().equals(modelStore.PatientAccountTerminationRequestStore.getUsers().get(patientNumber).getUsername()));
             assertTrue("test if the patient password is the same", pat.getPassword().equals(modelStore.PatientAccountTerminationRequestStore.getUsers().get(patientNumber).getPassword()));
             assertTrue("test if the patient firstname is the same", pat.getFirstName().equals(modelStore.PatientAccountTerminationRequestStore.getUsers().get(patientNumber).getFirstName()));
             assertTrue("test if the patient surname is the same", pat.getSurname().equals(modelStore.PatientAccountTerminationRequestStore.getUsers().get(patientNumber).getSurname()));
             assertTrue("test if the patient address is the same", pat.getAddress().equals(modelStore.PatientAccountTerminationRequestStore.getUsers().get(patientNumber).getAddress()));
             PatientModel tempPat = (PatientModel) modelStore.PatientAccountTerminationRequestStore.getUsers().get(patientNumber);
             PatientModel tempPatFromFile = (PatientModel) pat;
             assertTrue("test if the patient gender is the same", tempPat.getSex().equals(tempPatFromFile.getSex()));
             assertTrue("test if the patient age is the same", tempPat.getAge() == (tempPatFromFile.getAge()));
             patientNumber +=1;
         }
    
     }
     
     @Test
     public void TestDoctorStorageAfterFileRead(){
         int DoctorNumber = 0;
         for (UserModel dr: ReadFilestore.DoctorStore.getUsers()) {
             assertTrue("test if the Doctors Username is the same", dr.getUsername().equals(modelStore.DoctorStore.getUsers().get(DoctorNumber).getUsername()));
             assertTrue("test if the Doctors password is the same", dr.getPassword().equals(modelStore.DoctorStore.getUsers().get(DoctorNumber).getPassword()));
             assertTrue("test if the Doctors firstname is the same", dr.getFirstName().equals(modelStore.DoctorStore.getUsers().get(DoctorNumber).getFirstName()));
             assertTrue("test if the Doctors surname is the same", dr.getSurname().equals(modelStore.DoctorStore.getUsers().get(DoctorNumber).getSurname()));
             assertTrue("test if the Doctors address is the same", dr.getAddress().equals(modelStore.DoctorStore.getUsers().get(DoctorNumber).getAddress()));
             DoctorNumber +=1;
         }
     }
     @Test 
     public void TestSecertaryStorageAfterFileRead(){
         int SecertaryNumber = 0;
         for (UserModel sec: ReadFilestore.SecretaryStore.getUsers()) {
             assertTrue("test if the Secertary Username is the same", sec.getUsername().equals(modelStore.SecretaryStore.getUsers().get(SecertaryNumber).getUsername()));
             assertTrue("test if the Secertary password is the same", sec.getPassword().equals(modelStore.SecretaryStore.getUsers().get(SecertaryNumber).getPassword()));
             assertTrue("test if the Secertary firstname is the same", sec.getFirstName().equals(modelStore.SecretaryStore.getUsers().get(SecertaryNumber).getFirstName()));
             assertTrue("test if the Secertary surname is the same", sec.getSurname().equals(modelStore.SecretaryStore.getUsers().get(SecertaryNumber).getSurname()));
             assertTrue("test if the Secertary address is the same", sec.getAddress().equals(modelStore.SecretaryStore.getUsers().get(SecertaryNumber).getAddress()));
             SecertaryNumber +=1;
         }
     }
     @Test 
     public void TestAdminStorageAfterFileRead(){
         int AdminNumber = 0;
         for (UserModel ad: ReadFilestore.AdminStore.getUsers()) {
             assertTrue("test if the Admin Username is the same", ad.getUsername().equals(modelStore.AdminStore.getUsers().get(AdminNumber).getUsername()));
             assertTrue("test if the Admin password is the same", ad.getPassword().equals(modelStore.AdminStore.getUsers().get(AdminNumber).getPassword()));
             assertTrue("test if the Admin firstname is the same", ad.getFirstName().equals(modelStore.AdminStore.getUsers().get(AdminNumber).getFirstName()));
             assertTrue("test if the Admin surname is the same", ad.getSurname().equals(modelStore.AdminStore.getUsers().get(AdminNumber).getSurname()));
             assertTrue("test if the Admin address is the same", ad.getAddress().equals(modelStore.AdminStore.getUsers().get(AdminNumber).getAddress()));
             AdminNumber +=1;
         }
     }
     
     @Test 
     public void TestPrescriptionStorageAfterFileRead(){
         int PrescriptionNumber = 0;
         for (PrescriptionModel pre: ReadFilestore.PrescriptionStore.getPrescriptions()) {
             assertTrue("test if the Prescription date is the same", pre.getDatePrescriped().equals(modelStore.PrescriptionStore.getPrescriptions().get(PrescriptionNumber).getDatePrescriped()));
             assertTrue("test if the Prescription doctor is the same", pre.getDoctor().equals(modelStore.PrescriptionStore.getPrescriptions().get(PrescriptionNumber).getDoctor()));
             assertTrue("test if the Prescription medicine is the same", pre.getMedicine().getName().equals(modelStore.PrescriptionStore.getPrescriptions().get(PrescriptionNumber).getMedicine().getName()));
             assertTrue("test if the Prescription notes is the same", pre.getNotes().equals(modelStore.PrescriptionStore.getPrescriptions().get(PrescriptionNumber).getNotes()));
             assertTrue("test if the Prescription patient is the same", pre.getPatient().equals(modelStore.PrescriptionStore.getPrescriptions().get(PrescriptionNumber).getPatient()));
             assertTrue("test if the Prescription id is the same", pre.getPrescriptionID()==(modelStore.PrescriptionStore.getPrescriptions().get(PrescriptionNumber).getPrescriptionID()));
             PrescriptionNumber +=1;
         }
     }
     @Test 
     public void TestMedicineStorageAfterFileRead(){
         int MedicineNumber = 0;
         for (MedicineModel med: ReadFilestore.MedicineStore.getMedicine() ) {
             if (med.getDosage() != null) { 
                 assertTrue("test if the Medicine dosage is the same", med.getDosage().equals(modelStore.MedicineStore.getMedicine().get(MedicineNumber).getDosage()));
             } 
             assertTrue("test if the Medicine name is the same", med.getName().equals(modelStore.MedicineStore.getMedicine().get(MedicineNumber).getName()));
             assertTrue("test if the Medicine quantity is the same", med.getQuantity() == (modelStore.MedicineStore.getMedicine().get(MedicineNumber).getQuantity()));
             MedicineNumber +=1;
         }
     }
     
//     @Test 
//     public void TestFeedbackStorageAfterFileRead(){
//         int FeedbackNumber = 0;
//         for (DoctorFeedback feed: ReadFilestore.doctorFeedbackStore.getDoctorsFeedback()) {
//             assertTrue("test if the DoctorFeedback ID is the same", feed.getDoctorID().equals(modelStore.doctorFeedbackStore.getDoctorsFeedback().get(FeedbackNumber).getDoctorID()));
//             assertTrue("test if the DoctorFeedback notes is the same", feed.getFeedbackNotes().equals(modelStore.doctorFeedbackStore.getDoctorsFeedback().get(FeedbackNumber).getFeedbackNotes()));
//             assertTrue("test if the DoctorFeedback rating is the same", feed.getRating()== (modelStore.doctorFeedbackStore.getDoctorsFeedback().get(FeedbackNumber).getRating()));
//             assertTrue("test if the DoctorFeedback rating ID is the same", feed.getRatingID()== (modelStore.doctorFeedbackStore.getDoctorsFeedback().get(FeedbackNumber).getRatingID()));
//             FeedbackNumber +=1;
//         }
//     }
//     @Test 
//     public void TestPendingFeedbackStorageAfterFileRead(){
//         int FeedbackNumber = 0;
//         for (DoctorFeedback feed: ReadFilestore.doctorPendingFeedbackStore.getDoctorsFeedback()) {
//             assertTrue("test if the DoctorFeedback ID is the same", feed.getDoctorID().equals(modelStore.doctorPendingFeedbackStore.getDoctorsFeedback().get(FeedbackNumber).getDoctorID()));
//             assertTrue("test if the DoctorFeedback notes is the same", feed.getFeedbackNotes().equals(modelStore.doctorPendingFeedbackStore.getDoctorsFeedback().get(FeedbackNumber).getFeedbackNotes()));
//             assertTrue("test if the DoctorFeedback rating is the same", feed.getRating()== (modelStore.doctorPendingFeedbackStore.getDoctorsFeedback().get(FeedbackNumber).getRating()));
//             assertTrue("test if the DoctorFeedback rating ID is the same", feed.getRatingID()== (modelStore.doctorPendingFeedbackStore.getDoctorsFeedback().get(FeedbackNumber).getRatingID()));
//             FeedbackNumber +=1;
//         }
//     }
//     @Test 
//     public void TestAppointmentStorageAfterFileRead(){
//         int AppointmentNumber = 0;
//         for (Appointment ap: ReadFilestore.appointmentStore.getAppointments()) {
//             assertTrue("test if the Appointment doctor ID is the same", ap.getDoctorID().equals(modelStore.appointmentStore.getAppointments().get(AppointmentNumber).getDoctorID()));
//             assertTrue("test if the Appointment end time is the same", ap.getEndTime().equals(modelStore.appointmentStore.getAppointments().get(AppointmentNumber).getEndTime()));
//             assertTrue("test if the Appointment ID is the same", ap.getAppointmentID()== (modelStore.appointmentStore.getAppointments().get(AppointmentNumber).getAppointmentID()));
//             if (ap.getNotes()!= null){
//                 assertTrue("test if the Appointment notes is the same", ap.getNotes().equals(modelStore.appointmentStore.getAppointments().get(AppointmentNumber).getNotes()));
//             }
//             assertTrue("test if the Appointment PatientID  is the same", ap.getPatientID().equals(modelStore.appointmentStore.getAppointments().get(AppointmentNumber).getPatientID()));
//             if (ap.getReason() != null) {
//                 assertTrue("test if the Appointment reason is the same", ap.getReason().equals(modelStore.appointmentStore.getAppointments().get(AppointmentNumber).getReason()));
//             }
//             assertTrue("test if the Appointment start time is the same", ap.getStartTime().equals(modelStore.appointmentStore.getAppointments().get(AppointmentNumber).getStartTime()));
//             AppointmentNumber +=1;
//         }
//     }
//     @Test 
//     public void TestPendingAppointmentStorageAfterFileRead(){
//         int AppointmentNumber = 0;
//         for (Appointment ap: ReadFilestore.pendingAppointmentsStore.getAppointments()) {
//             assertTrue("test if the Appointment doctor ID is the same", ap.getDoctorID().equals(modelStore.pendingAppointmentsStore.getAppointments().get(AppointmentNumber).getDoctorID()));
//             assertTrue("test if the Appointment end time is the same", ap.getEndTime().equals(modelStore.pendingAppointmentsStore.getAppointments().get(AppointmentNumber).getEndTime()));
//             assertTrue("test if the Appointment ID is the same", ap.getAppointmentID()== (modelStore.pendingAppointmentsStore.getAppointments().get(AppointmentNumber).getAppointmentID()));
//             if (ap.getNotes()!= null){
//                 assertTrue("test if the Appointment notes is the same", ap.getNotes().equals(modelStore.pendingAppointmentsStore.getAppointments().get(AppointmentNumber).getNotes()));
//             }
//             assertTrue("test if the Appointment PatientID  is the same", ap.getPatientID().equals(modelStore.pendingAppointmentsStore.getAppointments().get(AppointmentNumber).getPatientID()));
//             if (ap.getReason() != null) {
//                 assertTrue("test if the Appointment reason is the same", ap.getReason().equals(modelStore.pendingAppointmentsStore.getAppointments().get(AppointmentNumber).getReason()));
//             }
//             assertTrue("test if the Appointment start time is the same", ap.getStartTime().equals(modelStore.pendingAppointmentsStore.getAppointments().get(AppointmentNumber).getStartTime()));
//             AppointmentNumber +=1;
//         }
//     }
}
