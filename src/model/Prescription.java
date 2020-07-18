/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ssangg_ss
 */
public class Prescription implements Serializable{
    private int id;
    private int idMedicine;
    private ArrayList<Medicine> medicine;

    public Prescription() {
    }

    public Prescription(int id, int idMedicine) {
        this.id = id;
        this.idMedicine = idMedicine;
    }

    
    public int getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(int idMedicine) {
        this.idMedicine = idMedicine;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    public ArrayList<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(ArrayList<Medicine> medicine) {
        this.medicine = medicine;
    }
}
