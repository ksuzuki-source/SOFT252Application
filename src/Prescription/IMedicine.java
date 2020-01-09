/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import java.util.ArrayList;

/**
 *
 * @author kouss
 */
public interface IMedicine {

    /**
     *abstract add medicine
     * @param medicine
     */
    public void addMedicine(MedicineModel medicine);

    /**
     * abstract remove medicine
     * @param medicine
     */
    public void removeMedicine(MedicineModel medicine);

    /**
     *abstract find medicine
     * @param medicine
     * @return a medicine object
     */
    public MedicineModel findMedicine(MedicineModel medicine);

    /**
     *abstract get all medicines
     * @return array list of medicine objects
     */
    public ArrayList<MedicineModel> getMedicine();
}
    

