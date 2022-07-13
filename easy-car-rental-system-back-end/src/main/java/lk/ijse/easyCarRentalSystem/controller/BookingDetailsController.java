package lk.ijse.easyCarRentalSystem.controller;

import lk.ijse.easyCarRentalSystem.dto.BookingDetailsDTO;
import lk.ijse.easyCarRentalSystem.dto.service.BookingDetailService;
import lk.ijse.easyCarRentalSystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/

@RestController
@RequestMapping("api/v1/bookingDetails")
@CrossOrigin
public class BookingDetailsController {

    @Autowired
    BookingDetailService bookingDetailService;

    @GetMapping(path = "/{bookingID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBooking(@PathVariable String bookingID) {
        System.out.println("Booking ID Search");
        System.out.println("Booking ID Search" + bookingID);
        ArrayList<BookingDetailsDTO> list = bookingDetailService.getBookingVehicle(bookingID);
        return new ResponseEntity(new ResponseUtil("200", "Done", bookingID), HttpStatus.OK);
    }
}
