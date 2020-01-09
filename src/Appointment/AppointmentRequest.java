/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author kouss
 */
public class AppointmentRequest  implements IAppointment, Serializable{
    ArrayList<AppointmentModel> appointments= new ArrayList<>();

    /**
     * Sets up the pending appointment class so can read from the file
     */
    public AppointmentRequest() {
    }

    /**
     * Method to add an appointment to the object
     * @param appointment
     */
    @Override
    public void addAppointment(AppointmentModel appointment) {
        appointments.add(appointment);
    }

    /**
     *Method to remove an appointment
     * @param appointment
     */
    @Override
    public void removeAppointment(AppointmentModel appointment) {
        appointments.remove(appointment);
    }

    /**
     *finds an appointment
     * @param appointment
     * @return
     */
    @Override
    public AppointmentModel findAppointment(AppointmentModel appointment) {
        int index = appointments.indexOf(appointment);
        return appointments.get(index);
    }

    /**
     *returns the appointment list
     * @return arraylist of appointment objects
     */
    @Override
    public ArrayList<AppointmentModel> getAppointments() {
        return this.appointments;
    }
}
