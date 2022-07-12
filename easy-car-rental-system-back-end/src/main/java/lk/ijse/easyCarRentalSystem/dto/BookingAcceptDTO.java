package lk.ijse.easyCarRentalSystem.dto;

import lk.ijse.easyCarRentalSystem.entity.BookingDetails;
import lk.ijse.easyCarRentalSystem.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingAcceptDTO {

    private String bookingID;

    private String rentDate;

    private String rentTime;

    private String returnDate;

    private String returnTime;

    private String bookingStatus;

    private Customer customerNICNumber;

    private List<BookingDetails> bookingDetails = new ArrayList<>();

}
