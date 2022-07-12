package lk.ijse.easyCarRentalSystem.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/
@ToString
@Data
public class CustomDTO {

    private String bookingID;

    private String rentDate;

    private String rentTime;

    private String returnDate;

    private String returnTime;

    private String customerNICNumber;

    private double lossDamageFee;

    private String driverNICNumber;

    private String vehicleRegID;

    private double finalPayment;

    public CustomDTO(String s, String toString, String string, String s1, double v, String toString1, String string1) {
    }

    public CustomDTO(String bookingID, String customerNICNumber, double finalPayment) {
        this.bookingID = bookingID;
        this.customerNICNumber = customerNICNumber;
        this.finalPayment = finalPayment;
    }

    public CustomDTO(String bookingID, String rentDate, String rentTime, String returnDate, String returnTime, String customerNICNumber, double lossDamageFee, String driverNICNumber, String vehicleRegID) {
        this.bookingID = bookingID;
        this.rentDate = rentDate;
        this.rentTime = rentTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.customerNICNumber = customerNICNumber;
        this.lossDamageFee = lossDamageFee;
        this.driverNICNumber = driverNICNumber;
        this.vehicleRegID = vehicleRegID;
    }

    public CustomDTO(String bookingID, String rentDate, String rentTime, String returnDate, String returnTime, String customerNICNumber, double lossDamageFee, String driverNICNumber, String vehicleRegID, double finalPayment) {
        this.bookingID = bookingID;
        this.rentDate = rentDate;
        this.rentTime = rentTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.customerNICNumber = customerNICNumber;
        this.lossDamageFee = lossDamageFee;
        this.driverNICNumber = driverNICNumber;
        this.vehicleRegID = vehicleRegID;
        this.finalPayment = finalPayment;
    }
}
