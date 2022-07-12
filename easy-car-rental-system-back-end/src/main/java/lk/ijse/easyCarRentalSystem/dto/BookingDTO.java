package lk.ijse.easyCarRentalSystem.dto;

import lk.ijse.easyCarRentalSystem.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingDTO {

    private String bookingID;

    private String bookingStatus;

    private String rentStatus;

    private String rentDate;

    private String rentTime;

    private String returnStatus;

    private String returnDate;

    private String returnTime;

    private Customer customerNICNumber;

    private List<BookingDetailsDTO> bookingDetails = new ArrayList<>();
}
