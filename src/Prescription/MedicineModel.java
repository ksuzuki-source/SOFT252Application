/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import java.io.Serializable;

/**
 *
 * @author kouss
 */
public class MedicineModel implements Serializable {
    private String name;
    private int quantity;
    private String dosage;

    /**
     * 
     * @param name
     * @param quantity
     * @param dosage
     */
    public MedicineModel(String name, int quantity, String dosage) {
        this.name = name;
        this.quantity = quantity;
        this.dosage = dosage;
    }

    /**
     * @param name
     * @param quantity
     */
    public MedicineModel(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    
    /**
     * get medicine name
     * @return medicine name
     */
    public String getName() {
        return name;
    }

    /**
     * set medicine name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *get medicine quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *set medicine quantity
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * get medicine dosage
     * @return medicine dosage
     */
    public String getDosage() {
        return dosage;
    }

    /**
     *set medicine dosage
     * @param dosage
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    
}
