package lk.ijse.easyCarRentalSystem.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/
public class BookingDTO {
    private String bookingID;

    private String bookingStatus;

    private String rentStatus;

    private String rentDate;

    private String rentTime;

    private String returnStatus;

    private String returnDate;

    private String returnTime;

    private List<BookingDetailsDTO> bookingDetails = new ArrayList<>();
}
