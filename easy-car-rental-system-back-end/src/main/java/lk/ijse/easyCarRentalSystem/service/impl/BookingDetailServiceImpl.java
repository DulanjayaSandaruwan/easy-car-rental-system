package lk.ijse.easyCarRentalSystem.service.impl;

import lk.ijse.easyCarRentalSystem.dto.BookingDetailsDTO;
import lk.ijse.easyCarRentalSystem.service.BookingDetailService;
import lk.ijse.easyCarRentalSystem.repo.BookingDetailsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@Service
@Transactional
public class BookingDetailServiceImpl implements BookingDetailService {

    @Autowired
    BookingDetailsRepo bookingDetailsRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public ArrayList<BookingDetailsDTO> getBookingVehicle(String bookingID) {
        return null;
    }
}
