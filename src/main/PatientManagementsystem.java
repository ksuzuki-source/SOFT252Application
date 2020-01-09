/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import Serializer.ReadFile;
import Serializer.WriteFile;
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
import Controllers.LoginRoleController;

/**
 *
 * @author kouss
 */
public class PatientManagementsystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            // TODO code application logic here
            PatientModel patient1 = new PatientModel(32,"female","Evan", "password", "Josh", "Evan","pl4 8ba");
            PatientModel patient2 = new PatientModel(25,"male","Emily", "password", "Emily", "Walker","pl4 8bx");
            PatientModel patient3  = new PatientModel(22,"male","Dan", "password", "Daniel", "Nin","pl2 e12");
            
            PatientStore patientStore = new PatientStore();
            
            patientStore.addUser(patient1);
            patientStore.addUser(patient2);
            patientStore.addUser(patient3);
            
            DoctorStore doctorStore = new DoctorStore();
            DoctorModel james = new DoctorModel("Aran", "password", "Aran","Tall","pl4 8ba ");
            DoctorModel sam = new DoctorModel("John", "password", "Jhon","Likker","pl2 8bx");
            DoctorModel jill = new DoctorModel("Jony", "password", "Jonny","Deppy","pl1 2ds");
            doctorStore.addUser(james);
            doctorStore.addUser(sam);
            doctorStore.addUser(jill);
            
            AdministratorModel admin1 = new AdministratorModel("kouss", "password", "Kohei", "Suzuki","pl4 23");
            AdministratorStore adminStore = new AdministratorStore();
            adminStore.addUser(admin1);
            
            SecretaryModel sec1 = new SecretaryModel("Ange", "password", "Ange","Helest","pl5 8ds");
            SecretaryStore secretaryStore = new SecretaryStore();
            secretaryStore.addUser(sec1);
//            
//            
            PrescriptionStore prescriptionStore = new PrescriptionStore();
            LocalDateTime now = LocalDateTime.now();
            MedicineModel med = new MedicineModel("paracemtol", 20 , "2 a day");
            PrescriptionModel pre = new PrescriptionModel( 0 ,"Josh","Evan","","06/Dec" ,med);
//        pre.addMedicine(med);
            prescriptionStore.addPrescription(pre);

            MedicineModel med1 = new MedicineModel("paracemtol", 200);
            MedicineModel med2 = new MedicineModel("Solcicsola", 300 );
            MedicineModel med3 = new MedicineModel("Naxfloxal", 60 );
            MedicineModel med4 = new MedicineModel("Nitradexobo", 220 );
            MedicineModel med5 = new MedicineModel("Hobix", 190 );
            MedicineModel med6 = new MedicineModel("Enthsol", 110 );
            MedicineModel med7= new MedicineModel("Ectiridril", 160 );
            MedicineModel med8 = new MedicineModel("Anthcinui", 150 );
            MedicineModel med9 = new MedicineModel("Ganfloxart", 120 );
            MedicineModel med10 = new MedicineModel("Lincilagro", 130 );
            
            
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
            DoctorFeedback feedback3 = new DoctorFeedback("John",1,"bad doctor and is very busy",1);
            DoctorFeedback feedback4 = new DoctorFeedback("John",5,"good doctor but is very busys",2);
            doctorFeedbackStore.addDoctorFeedback(feedback3);
            doctorFeedbackStore.addDoctorFeedback(feedback4);


            AppointmentStore appointmentStore = new AppointmentStore();
            AppointmentModel app = new AppointmentModel(0,"09/Oct","Jonny","Deppy");
            AppointmentModel app4 = new AppointmentModel(1,"20/Dec","Jonny", "Deppy");
            app.setCompleted(true);
            appointmentStore.addAppointment(app);
            appointmentStore.addAppointment(app4);

            AppointmentRequest pendingAppointmentsStore = new AppointmentRequest();
            AppointmentModel app1 = new AppointmentModel(0,"13/Jan","Jonny","Deppy");
            AppointmentModel app2 = new AppointmentModel(1,"20/Jan","Jonny","Deppy");
            pendingAppointmentsStore.addAppointment(app1);
            pendingAppointmentsStore.addAppointment(app2);

            PatientAccountRequest pendingAccountsStore = new PatientAccountRequest();
            PatientModel patient4  = new PatientModel(25,"female","Elly", "password", "Elly", "Konifar","SomeWhere");
            PatientModel patient5  = new PatientModel(44,"male","Miho", "password", "Miho", "Sato","Everywhere");
            pendingAccountsStore.addUser(patient4);
            pendingAccountsStore.addUser(patient5);

            PatientAccountTerminationRequest pendingTerminateAccountsStore = new PatientAccountTerminationRequest();
            pendingTerminateAccountsStore.addUser(patient1);

           ModelsStore temp = null;         
           ReadFile file = new ReadFile();
           ModelsStore store = file.executeAction(temp);
            
            
        
            
        LoginRoleController Controller = new LoginRoleController(store);
    }
    
    }
    

