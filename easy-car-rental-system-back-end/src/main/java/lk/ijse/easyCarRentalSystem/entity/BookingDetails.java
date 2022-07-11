package lk.ijse.easyCarRentalSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/

@Entity
public class BookingDetails {

    @Id
    private int bookingDetailsID;

    private double lossDamageFee;

    private String lossDamageFeeSlip;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "bookingID", referencedColumnName = "bookingID")
    private Booking bookingID;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "vehicleRegID", referencedColumnName = "vehicleRegID")
    private Vehicle vehicleRegID;

    @ManyToOne
    @JoinColumn(name = "driverNICNumber", referencedColumnName = "driverNICNumber")
    private Driver driverNICNumber;

    public BookingDetails() {
    }

    public BookingDetails(int bookingDetailsID, double lossDamageFee, Booking bookingID, Vehicle vehicleRegID) {
        this.bookingDetailsID = bookingDetailsID;
        this.lossDamageFee = lossDamageFee;
        this.bookingID = bookingID;
        this.vehicleRegID = vehicleRegID;
    }

    public BookingDetails(double lossDamageFee, String lossDamageFeeSlip, Booking bookingID, Vehicle vehicleRegID, Driver driverNICNumber) {
        this.lossDamageFee = lossDamageFee;
        this.lossDamageFeeSlip = lossDamageFeeSlip;
        this.bookingID = bookingID;
        this.vehicleRegID = vehicleRegID;
        this.driverNICNumber = driverNICNumber;
    }

    public int getBookingDetailsID() {
        return bookingDetailsID;
    }

    public void setBookingDetailsID(int bookingDetailsID) {
        this.bookingDetailsID = bookingDetailsID;
    }

    public double getLossDamageFee() {
        return lossDamageFee;
    }

    public void setLossDamageFee(double lossDamageFee) {
        this.lossDamageFee = lossDamageFee;
    }

    public String getLossDamageFeeSlip() {
        return lossDamageFeeSlip;
    }

    public void setLossDamageFeeSlip(String lossDamageFeeSlip) {
        this.lossDamageFeeSlip = lossDamageFeeSlip;
    }

    public Booking getBookingID() {
        return bookingID;
    }

    public void setBookingID(Booking bookingID) {
        this.bookingID = bookingID;
    }

    public Vehicle getVehicleRegID() {
        return vehicleRegID;
    }

    public void setVehicleRegID(Vehicle vehicleRegID) {
        this.vehicleRegID = vehicleRegID;
    }

    public Driver getDriverNICNumber() {
        return driverNICNumber;
    }

    public void setDriverNICNumber(Driver driverNICNumber) {
        this.driverNICNumber = driverNICNumber;
    }
}
