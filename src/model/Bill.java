package model;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable{
	private int id;
	private String paymentType;
        private String date;
        private String stk;
        private String tenchuthe;
	private Booking booking;

    public Bill() {
    }

    public Bill(int id, String paymentType, String date, String stk, String tenchuthe, Booking booking) {
        this.id = id;
        this.paymentType = paymentType;
        this.date = date;
        this.stk = stk;
        this.tenchuthe = tenchuthe;
        this.booking = booking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getTenchuthe() {
        return tenchuthe;
    }

    public void setTenchuthe(String tenchuthe) {
        this.tenchuthe = tenchuthe;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    
}
