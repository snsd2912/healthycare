package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Booking implements Serializable{
	private int id;
	private Client client;
	private Doctor doctor;
	private String bookedDate;
	private Shift shift;
        private int isPaid;
        
    public Booking() {
    }

    public Booking(int id, Client client, Doctor doctor, String bookedDate, Shift shift,int isPaid) {
        this.id = id;
        this.client = client;
        this.doctor = doctor;
        this.bookedDate = bookedDate;
        this.shift = shift;
        this.isPaid = isPaid;
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

    public String getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(String bookedDate) {
        this.bookedDate = bookedDate;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public int getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
    }

    
}
