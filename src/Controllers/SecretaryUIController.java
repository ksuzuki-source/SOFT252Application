/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Serializer.WriteFile;
import Views.SecretaryUI;
import Appointment.AppointmentModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Models.ModelsStore;
import Patient.PatientModel;
import Prescription.MedicineModel;
import Prescription.PrescriptionModel;
import UserModel.UserModel;

/**
 *
 * @author kouss
 */
public class SecretaryUIController {
    
    
       /**
     *This is were the view is stored
     */
    public SecretaryUI SecretaryView;

    /**
     * This is the models storage
     */
    public ModelsStore modelStore;

    /**
     * Object to initalise the writefile object
     */
    public WriteFile file = new WriteFile();

    /**
     *Constructor to set up the controller
     * <p> initalises the Secretary view and modelStore</p>
     * <p> sets up the users, apppointments and medStock on screen</p>
     * <p> sets up the onClicks listeners </p>
     * @param modelStore
     * @param UserID
     */
    public SecretaryUIController(ModelsStore modelStore, String UserID) {
        this.modelStore = modelStore;
        this.SecretaryView = new SecretaryUI();
        SecretaryView.setVisible(true);
        SecretaryView.setTxtSecretaryID(UserID);
        setUpOnClicks();
        setUpUsers();
        setUpPendingAppointments();
        setUpDoctorAppointment();
        setUpMedStock();
        
        
    }

    /**
     *Save the model to file
     * <p> calls the writeFile object to write the models to the file</p>
     */
    public void saveData(){
        file.executeAction(modelStore);
    } 
    private void setUpOnClicks(){
        SecretaryView.listApprovePatientListener(new SecretaryUIController.ShowPendingPatient());
        this.SecretaryView.btnApprovePatient(new SecretaryUIController.ApprovePatient());
        this.SecretaryView.btnRemovePatient(new SecretaryUIController.RemovePatient());
        this.SecretaryView.listPatientListener(new SecretaryUIController.showUsernamePatient());
        this.SecretaryView.listTermiatePatientListener(new SecretaryUIController.showUsernameTerminatePatient());
        this.SecretaryView.listPendingAppointmentsonClick(new SecretaryUIController.ShowPendingAppointment());
        this.SecretaryView.btnCreateAppointmentListener(new SecretaryUIController.CreateAppointment());
    }

    private void setUpUsers() {
        //set up pending Patients
        setUpPendingPatientList();
        setUpPatients();
        setUpPatientsTerminate();
    }
    private void setUpPendingPatientList(){
        int pendingPLength = modelStore.AccountsRequestStore.getUsers().size();
        String[] pendingPList = new String[pendingPLength];
        for (int i = 0; i < pendingPLength; i++) {
            pendingPList[i] = modelStore.AccountsRequestStore.getUsers().get(i).getUsername();
           
        }
        SecretaryView.setListApprovePatient(pendingPList);
         
    }
    private void setUpPatients(){
        int pLength = modelStore.PatientStore.getUsers().size();
        String[] pList = new String[pLength];
        for (int i = 0; i < pLength; i++) {
            pList[i] = modelStore.PatientStore.getUsers().get(i).getUsername();
           
        }

    }
    private void setUpPatientsTerminate(){
        int pLength = modelStore.PatientAccountTerminationRequestStore.getUsers().size();
        String[] tPList = new String[pLength];
        for (int i = 0; i < pLength; i++) {
            tPList[i] = modelStore.PatientAccountTerminationRequestStore.getUsers().get(i).getUsername();
           
        }
        SecretaryView.setListPatientTerminate(tPList);
    }
    private void setUpPendingAppointments(){
        int aLength = modelStore.AppointmentRequestStore.getAppointments().size();
        String[] appList = new String[aLength];
        for (int i = 0; i < aLength; i++) {
            appList[i] = Integer.toString(modelStore.AppointmentRequestStore.getAppointments().get(i).getAppointmentID());
           
        }
        SecretaryView.setListPendingAppointments(appList);
    }
    private void setUpDoctorAppointment(){
        for (UserModel dr : modelStore.DoctorStore.getUsers()) {
             SecretaryView.addBoxDoctor(dr.getUsername());
        }
    }
    private void setUpMedStock(){
        int medLength = modelStore.MedicineStore.getMedicine().size();
        String[] medList = new String[medLength];
        for (int i = 0; i < medLength; i++) {
            medList[i] = (modelStore.MedicineStore.getMedicine().get(i).getName());
           
        }
             
    }
    private void clearPendingPatientFields(){
        SecretaryView.setTxtApproveUsername("");
        SecretaryView.setTxtApproveFirstname("");
        SecretaryView.setTxtApproveSurname("");
        SecretaryView.setTxtApprovePassword("");
        SecretaryView.setTxtApproveAddress("");
        SecretaryView.setTxtApproveGender("");
        SecretaryView.setTxtApproveAge("");
    }
    private void clearAppointmentInfo(){
        SecretaryView.setTxtAppointmentID("");
        SecretaryView.setTxtUserStart("");
        SecretaryView.setTxtRequestDoctor("");
        SecretaryView.setTxtPatientApp("");
    }
    class ShowPendingPatient implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String patientID = SecretaryView.getListApprovePatient();
            for(UserModel pat : modelStore.AccountsRequestStore.getUsers()){
                if (pat.getUsername().equals(patientID)) {
                    SecretaryView.setTxtApproveUsername(pat.getUsername());
                    SecretaryView.setTxtApprovePassword(pat.getPassword());
                    SecretaryView.setTxtApproveFirstname(pat.getFirstName());
                    SecretaryView.setTxtApproveSurname(pat.getSurname());
                    SecretaryView.setTxtApproveAddress(pat.getAddress());
                    PatientModel tempP = (PatientModel)pat;
                    SecretaryView.setTxtApproveGender(tempP.getSex());
                    SecretaryView.setTxtApproveAge(Integer.toString(tempP.getAge()));
                    
                    
                }
            }
            
        }
        
    }
    class ApprovePatient implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String patientID = SecretaryView.getTxtApproveUsername();
            String password = SecretaryView.getTxtApprovePassword();
            String firstname = SecretaryView.getTxtApproveFirstname();
            String surname = SecretaryView.getTxtApproveSurname();
            String address = SecretaryView.getTxtApproveSurname();
            String gender = SecretaryView.getTxtApproveGender();
            int age = Integer.parseInt(SecretaryView.getTxtApproveAge());
            
            PatientModel tempP = new PatientModel(age,gender, patientID,password, firstname, surname,address);
            modelStore.PatientStore.addUser(tempP);
            
            //remove patient from pending
            for(UserModel pat : modelStore.AccountsRequestStore.getUsers()){
                if (pat.getUsername().equals(patientID)) {
                    modelStore.AccountsRequestStore.removeUser(pat);
                    break;
                }
            }
            setUpPendingPatientList();
            clearPendingPatientFields();
            setUpUsers();
            saveData();
            
            
            
        }
        
    }
    class RemovePatient implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String patientID = SecretaryView.getTxtRemoveUsername();
            for (UserModel pat : modelStore.PatientStore.getUsers()) {
                if (pat.getUsername().equals(patientID)) {
                    modelStore.PatientStore.removeUser(pat);
                    for(UserModel patRemove : modelStore.PatientAccountTerminationRequestStore.getUsers()){
                        if (patRemove.getUsername().equals(pat.getUsername())) {
                            modelStore.PatientAccountTerminationRequestStore.removeUser(patRemove);
                        }
                    }
                    
                }
            }
            setUpUsers();
            SecretaryView.setTxtRemoveUsername("");
            saveData();
            
            
        }
        
    }
    class showUsernamePatient implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            
            String patientID = SecretaryView.getListPatients();
            
            for (UserModel pat : modelStore.PatientStore.getUsers()) {
                if (pat.getUsername().equals(patientID)) {
                    
                    SecretaryView.setTxtRemoveUsername(patientID);
                    SecretaryView.deselectPatientTerminateList();
                }
            }
            saveData();
        }
        
    }
    class showUsernameTerminatePatient implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
           
           String patientID = SecretaryView.getListPatientTerminate();
            for (UserModel pat : modelStore.PatientStore.getUsers()) {
                if (pat.getUsername().equals(patientID)) {
                    
                    SecretaryView.setTxtRemoveUsername(patientID);
                    SecretaryView.deselectPatientList();
                }
            }
        }
        
    }
    class ShowPendingAppointment implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(SecretaryView.getListPendingAppointments() != null){
                
                int appointmentID = Integer.parseInt(SecretaryView.getListPendingAppointments());
                //loop thorugh all of the pending appointmenst for the info needed
                for(AppointmentModel ap : modelStore.AppointmentRequestStore.getAppointments()){
                    if (appointmentID == ap.getAppointmentID()) {
                        SecretaryView.setTxtAppointmentID(Integer.toString(ap.getAppointmentID()));
                        SecretaryView.setTxtUserStart(ap.getDate());
                        SecretaryView.setTxtRequestDoctor(ap.getDoctorID());
                        SecretaryView.setTxtPatientApp(ap.getPatientID());
                    }
                }
            }
            
            
        }
        
    }
    class CreateAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String Date = SecretaryView.getTxtUserStart(); 
            String doctor = SecretaryView.getBoxDoctor();
            String patientID = SecretaryView.getTxtPatientApp();
            int SizeOfAppoitments = modelStore.AppointmentStore.getAppointments().size() -1;
            int getAppointmentID = modelStore.AppointmentStore.getAppointments().get(SizeOfAppoitments).getAppointmentID() +1;
            AppointmentModel ap = new AppointmentModel(getAppointmentID, Date, doctor, patientID);
            boolean isInList = false;
            for (AppointmentModel tempAp : modelStore.AppointmentStore.getAppointments()) {
                if (tempAp.getDoctorID().equals(doctor)){
                    
                }
                else{
                       isInList = true;
                    }
                }
            
            if (isInList) {
                SecretaryView.setTxtAppResponse("The doctor is busy at those times");

            }
            saveData();
            
            
        }
       

        
  
    }
}
