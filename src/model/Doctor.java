/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ssangg_ss
 */
public class Doctor extends Staff implements Serializable{
    private int idlevel;
    private int iddepartment;

    public Doctor() {
        super();
    }
    
    public Doctor(int idlevel,int iddepartment,int id, String username, String password, 
                        String name, String position, Date dob, String gender, String phonenumber){
        super(id,username,password,name,position,dob,gender,phonenumber);
        this.idlevel = idlevel;
        this.iddepartment = iddepartment;
    }

    public int getIdlevel() {
        return idlevel;
    }

    public void setIdlevel(int idlevel) {
        this.idlevel = idlevel;
    }

    public int getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(int iddepartment) {
        this.iddepartment = iddepartment;
    }
}
