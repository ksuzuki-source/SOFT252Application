/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kouss
 */
public class MedicineStore implements IMedicine , Serializable{
    ArrayList<MedicineModel> medicines = new ArrayList<>();


    public MedicineStore() {
    }

    /**
     * add a medicine to the medicine store
     * @param medicine
     */
    @Override
    public void addMedicine(MedicineModel medicine) {
        medicines.add(medicine);
    }

    /**
     * remove a medicine to the medicine store
     * @param medicine
     */
    @Override
    public void removeMedicine(MedicineModel medicine) {
        medicines.remove(medicine);
    }

    /**
     * @param medicine
     * @return the medicine index
     */
    @Override
    public MedicineModel findMedicine(MedicineModel medicine) {
        int index = medicines.indexOf(medicine);
        return medicines.get(index);
    }

    /**
     * get all the medicines
     * @return array list of medicine objects
     */
    @Override
    public ArrayList<MedicineModel> getMedicine() {
        return this.medicines;
    }
    
}
