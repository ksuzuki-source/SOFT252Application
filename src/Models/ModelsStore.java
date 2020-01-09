/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import java.io.Serializable;
import Administrator.AdministratorStore;
import Appointment.AppointmentStore;
import Appointment.AppointmentRequest;
import Doctor.DoctorFeedbackStore;
import Doctor.DoctorStore;
import Patient.PatientStore;
import Patient.PatientAccountRequest;
import Patient.PatientAccountTerminationRequest;
import Prescription.MedicineStore;
import Prescription.PrescriptionStore;
import Secretary.SecretaryStore;

/**
 *
 * @author kouss
 */

public class ModelsStore implements Serializable{
    //User models
    public PatientStore PatientStore;
    public DoctorStore DoctorStore;
    public AdministratorStore AdminStore;
    public SecretaryStore SecretaryStore;
    public MedicineStore MedicineStore;
    public PrescriptionStore PrescriptionStore;
    public DoctorFeedbackStore DoctorFeedbackStore;
    public AppointmentStore AppointmentStore;
    public AppointmentRequest AppointmentRequestStore;
    public PatientAccountRequest AccountsRequestStore;
    public PatientAccountTerminationRequest PatientAccountTerminationRequestStore;


public ModelsStore(PatientStore PatientStore, DoctorStore DoctorStore, AdministratorStore AdminStore, SecretaryStore SecretaryStore, MedicineStore MedicineStore, PrescriptionStore PrescriptionStore, DoctorFeedbackStore DoctorFeedbackStore, AppointmentStore AppointmentStore, AppointmentRequest AppointmentRequest, PatientAccountRequest PatientAccountRequest, PatientAccountTerminationRequest PatientAccountTerminationRequest) {
        this.PatientStore = PatientStore;
        this.DoctorStore = DoctorStore;
        this.AdminStore = AdminStore;
        this.SecretaryStore = SecretaryStore;
        this.MedicineStore = MedicineStore;
        this.PrescriptionStore = PrescriptionStore;
        this.DoctorFeedbackStore = DoctorFeedbackStore;
        this.AppointmentStore = AppointmentStore;
        this.AppointmentRequestStore = AppointmentRequestStore;
        this.AccountsRequestStore = AccountsRequestStore;
        this.PatientAccountTerminationRequestStore = PatientAccountTerminationRequestStore;
    }
}