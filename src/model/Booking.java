package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Booking implements Serializable{
	private int id;
	private Client client;
	private Doctor doctor;
	private Date bookedDate;
	private int shift;

    public Booking() {
    }

    public Booking(int id, Client client, Doctor doctor, Date bookedDate, int shift) {
        this.id = id;
        this.client = client;
        this.doctor = doctor;
        this.bookedDate = bookedDate;
        this.shift = shift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    
}
