package lk.ijse.easyCarRentalSystem.dto.service;

import lk.ijse.easyCarRentalSystem.dto.BookingAcceptDTO;
import lk.ijse.easyCarRentalSystem.dto.BookingDTO;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
public interface BookingService {
    void addBooking(BookingDTO bookingDTO);

    ArrayList<BookingAcceptDTO> getPendingRent();

    void updatePending(BookingDTO dto);

    void updateVehicle(BookingDTO dto);

    void updateReject(BookingDTO dto);

    BookingDTO searchBooking(String bookingID);

    String getLastRid();
}
