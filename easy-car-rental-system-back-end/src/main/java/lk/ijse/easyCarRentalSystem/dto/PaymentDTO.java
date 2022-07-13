package lk.ijse.easyCarRentalSystem.dto;

import lk.ijse.easyCarRentalSystem.entity.Booking;
import lk.ijse.easyCarRentalSystem.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PaymentDTO {

    private int paymentID;

    private double finalPayment;

    private Customer customerNICNumber;

    private Booking bookingID;
}
