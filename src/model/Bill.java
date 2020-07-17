package model;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable{
	private int id;
	private Date paymentDate;
	private float price;
	private String paymentType;
	private Booking booking;

    public Bill() {
    }

    public Bill(int id, Date paymentDate, float price, String paymentType, Booking booking) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.price = price;
        this.paymentType = paymentType;
        this.booking = booking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
	
    
}
