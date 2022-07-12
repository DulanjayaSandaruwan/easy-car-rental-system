package lk.ijse.easyCarRentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Payment {

    @Id
    private int paymentID;

    private double finalPayment;

    @ManyToOne
    @JoinColumn(name = "customerNICNumber", referencedColumnName = "customerNICNumber")
    private Customer customerNICNumber;

    @ManyToOne
    @JoinColumn(name = "bookingID", referencedColumnName = "bookingID")
    private Booking bookingID;

    public Payment(double finalPayment, Customer customerNICNumber, Booking bookingID) {
        this.finalPayment = finalPayment;
        this.customerNICNumber = customerNICNumber;
        this.bookingID = bookingID;
    }
}
