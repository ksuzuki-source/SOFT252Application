/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import java.util.ArrayList;

/**
 *
 * @author kouss
 */

public interface IAppointment {
    

    
    public void addAppointment(AppointmentModel appointment);


    public void removeAppointment(AppointmentModel appointment);


    public AppointmentModel findAppointment(AppointmentModel appointment);


    public ArrayList<AppointmentModel> getAppointments();
   
    
}
