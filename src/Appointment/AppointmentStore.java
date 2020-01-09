/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kouss
 */
public class AppointmentStore implements IAppointment , Serializable {
    ArrayList<AppointmentModel> appointments= new ArrayList<>();

    public AppointmentStore() {
    }

    /**
     *adds appointment
     * <p> adds appointment by passing in an appointment object</p>
     * @param appointment
     */
    @Override
    public void addAppointment(AppointmentModel appointment) {
        appointments.add(appointment);
    }

    /**
     *removes appointment
     * <p> removes appointment by passing in a appointment object </p>
     * @param appointment
     */
    @Override
    public void removeAppointment(AppointmentModel appointment) {
        appointments.remove(appointment);
    }

    /**
     * finds appointment
     * <p> finds appointment by passing in an appointment object </p>
     * @param appointment
     * @return an appointment index
     */
    @Override
    public AppointmentModel findAppointment(AppointmentModel appointment) {
        int index = appointments.indexOf(appointment);
        return appointments.get(index);
    }

    /**
     *return appointments
     * @return array list of appointment objects
     */
    @Override
    public ArrayList<AppointmentModel> getAppointments() {
        return this.appointments;
    }
    
}
