package model;

import java.io.Serializable;
import java.util.Date;

public class Staff implements Serializable{
    private int id;
    private String username;
    private String password;
    private String name;
    private String position;
    private String dob;
    private String gender;
    private String phonenumber;

    public Staff() {
    }

    public Staff(int id, String username, String password, String name, String position, String dob, String gender, String phonenumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.position = position;
        this.dob = dob;
        this.gender = gender;
        this.phonenumber = phonenumber;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }	
}
