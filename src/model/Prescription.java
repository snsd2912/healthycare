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
    private ArrayList<Medicine> medicine;

    public Prescription() {
    }

    public Prescription(int id, ArrayList<Medicine> medicine) {
        this.id = id;
        this.medicine = medicine;
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
