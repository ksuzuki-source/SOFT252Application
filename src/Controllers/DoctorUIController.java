/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Serializer.WriteFile;
import Views.DoctorUI;
import Appointment.AppointmentModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.time.LocalDateTime;
import Models.ModelsStore;
import Prescription.MedicineModel;
import Prescription.PrescriptionModel;
import UserModel.UserModel;

/**
 *
 * @author kouss
 */
public class DoctorUIController {
    /**
     *Sets up the modelStore
     */
    public ModelsStore modelStore;

    /**
     * this is were the view is stored
     */
    public DoctorUI DoctorView;

    /**
     *The writeFile is Initialised here
     */
    public WriteFile file = new WriteFile();

    /**
     * @param modelStore
     * @param UserID
     */
    public DoctorUIController(ModelsStore modelStore, String UserID) {
        this.modelStore = modelStore;
        this.DoctorView = new DoctorUI();
        DoctorView.setVisible(true);
        DoctorView.setTxtDoctorID(UserID);
        setUpOnClicks();
        setUpAppointment();
        setUpPatients();
    }

    /**
     *Save the model to file
     */
    public void saveData(){
        file.executeAction(modelStore);
    } 
    private void setUpOnClicks(){
        this.DoctorView.listAppointmentsOnChange(new DoctorUIController.ShowAppointment());
        this.DoctorView.btnCompleteAppointment(new DoctorUIController.CompleteAppointment());
        this.DoctorView.listHistoryPatientOnChange(new DoctorUIController.showHistoryAppointments());
        this.DoctorView.listHistoryAppointmentsOnChange(new DoctorUIController.showHistoryAppointmentInfo());
        this.DoctorView.listPatientPrescribeOnChange(new DoctorUIController.SelectPatientPrescibe());
        this.DoctorView.btnPrescribeMedicine(new DoctorUIController.savePrescription());
        this.DoctorView.btnSubmitAppointment(new DoctorUIController.DoctorRequestAppointment());
    }
    private void setUpAppointment(){
        int appointLength = modelStore.AppointmentStore.getAppointments().size();
        String[] appointments = new  String[modelStore.AppointmentStore.getAppointments().size()];
        String doctorID = this.DoctorView.getTxtDoctorID();
        for (int i = 0; i < appointLength; i++) {
            if (doctorID.equals(modelStore.AppointmentStore.getAppointments().get(i).getDoctorID()) && modelStore.AppointmentStore.getAppointments().get(i).isCompleted() == false) {
                appointments[i] = Integer.toString(modelStore.AppointmentStore.getAppointments().get(i).getAppointmentID());
            }
        }
        
        this.DoctorView.setListAppointments(appointments);
    }
    private void setUpPatients(){
        int pLength = modelStore.PatientStore.getUsers().size();
        String[] pList = new String[pLength];
        for (int i = 0; i < pLength; i++) {
            pList[i] = modelStore.PatientStore.getUsers().get(i).getUsername();
           
        }
        DoctorView.setListHistoryPatient(pList);
        DoctorView.setListPatientPrescribe(pList);
        for (UserModel pat : modelStore.PatientStore.getUsers()) {
            DoctorView.setBoxPatient(pat.getUsername());
        }
        
    }
    private void clearAppointmentInfo(){
        DoctorView.setTxtAppointmentID("");
        DoctorView.setTxtAppointmentDate("");
        DoctorView.setTxtAppointmentPatient("");
        DoctorView.setTxtAppointmentReason("");
        DoctorView.setTxtAppointmentNotes("");
    }
    private void clearPrescriptionInfo(){
        DoctorView.setTxtPrescribeMedDose("");
        DoctorView.setTxtPrescribeMedName("");
        DoctorView.setTxtPrescribeMedQty("");
        DoctorView.setTxtPrescribeNotes("");
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class ShowAppointment implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (DoctorView.getListAppointments() != null) {
                int appointmentID = Integer.parseInt(DoctorView.getListAppointments());
            for(AppointmentModel app : modelStore.AppointmentStore.getAppointments()){
                if (app.getAppointmentID() == appointmentID) {
                    DoctorView.setTxtAppointmentID(Integer.toString(app.getAppointmentID()));
                    DoctorView.setTxtAppointmentDate(app.getDate());
                    DoctorView.setTxtAppointmentPatient(app.getPatientID());
                    DoctorView.setTxtAppointmentReason(app.getReason());
                    DoctorView.setTxtAppointmentNotes(app.getNotes());
                }
            }
            }
            
            
        }
        
    }
    class CompleteAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int appointmentID = Integer.parseInt(DoctorView.getTxtAppointmentID());
            String notes = DoctorView.getTxtAppointmentNotes();
            for(AppointmentModel app : modelStore.AppointmentStore.getAppointments()){
                if (app.getAppointmentID() == appointmentID) {
                    app.setNotes(notes);
                    app.setCompleted(true);
                }
                
            }
            DoctorView.deselectAppointment();
            clearAppointmentInfo();
            setUpAppointment();
            saveData();
        }
        
    }
    class showHistoryAppointments implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String patientID = DoctorView.getListHistoryPatient();
            int pLength = modelStore.AppointmentStore.getAppointments().size();
            String[] pList = new String[pLength];
            for (int i = 0; i < pLength; i++) {
                if(modelStore.AppointmentStore.getAppointments().get(i).getPatientID().equals(patientID) && modelStore.AppointmentStore.getAppointments().get(i).isCompleted()){
                    pList[i] = Integer.toString(modelStore.AppointmentStore.getAppointments().get(i).getAppointmentID());
                }  
            }
            DoctorView.setListHistoryAppointments(pList);
            saveData();
                    
        }
        
    }
    class showHistoryAppointmentInfo implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (DoctorView.getListHistoryAppointments() != null) {
                int appID = Integer.parseInt(DoctorView.getListHistoryAppointments());
            for(AppointmentModel app : modelStore.AppointmentStore.getAppointments()){
                if (app.getAppointmentID() == appID) {
                    DoctorView.setHistoryTxtAppointmentID(Integer.toString(app.getAppointmentID()));
                    DoctorView.setHistoryTxtAppointmentDate(app.getDate());
                    DoctorView.setTxtHistoryAppointmentPatient(app.getPatientID());
                    DoctorView.setTxtHistoryAppointmentReason(app.getReason());
                    DoctorView.setTxtHistoryAppointmentNotes(app.getNotes());
                }
                
            }
            saveData();
            }
            
            
            
                    
        }
        
    }
    class SelectPatientPrescibe implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String patientID = DoctorView.getListPatientPrescribe();
            DoctorView.setTxtPrescribePatient(patientID);
            
        }
        
        
    }
    class savePrescription implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String patientID = DoctorView.getTxtPrescribePatient();
            String doctorID = DoctorView.getTxtDoctorID();
            String medName = DoctorView.getTxtPrescribeMedName();
            String medQty = DoctorView.getTxtPrescribeMedQty();
            String medDose = DoctorView.getTxtPrescribeMedDose();
            String notes = DoctorView.getTxtPrescribeNotes();
            String Date = DoctorView.getDate();
            int prescriptionID = modelStore.PrescriptionStore.getPrescriptions().size();
            MedicineModel med = new MedicineModel(medName, Integer.parseInt(medQty),medDose );
            
            PrescriptionModel newPresc = new PrescriptionModel(prescriptionID, patientID, doctorID, notes,
            Date ,med);
            modelStore.PrescriptionStore.addPrescription(newPresc);
            clearPrescriptionInfo();
            saveData();
        }
        
    }
       
    class DoctorRequestAppointment implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
            
            String Date = DoctorView.getDate(); 
            
            
            String doctor = DoctorView.getTxtDoctorID();
            String patientID = DoctorView.getBoxPatient();
            
            int SizeOfAppoitments = modelStore.AppointmentStore.getAppointments().size() -1;
            int getAppointmentID = modelStore.AppointmentStore.getAppointments().get(SizeOfAppoitments).getAppointmentID() +1;
            AppointmentModel ap = new AppointmentModel(getAppointmentID, Date, doctor, patientID);
            modelStore.AppointmentRequestStore.addAppointment(ap);
            saveData();
            
        }
     
    }
    
}
