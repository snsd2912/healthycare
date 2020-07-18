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
    private Level level;
    private Department department;

    public Doctor() {
        super();
    }
    
    public Doctor(Level idlevel,Department iddepartment,int id, String username, String password, 
                        String name, String position, String dob, String gender, String phonenumber){
        super(id,username,password,name,position,dob,gender,phonenumber);
        this.level = idlevel;
        this.department = iddepartment;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
