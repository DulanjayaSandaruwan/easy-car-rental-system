package lk.ijse.easyCarRentalSystem.dto.service.impl;

import lk.ijse.easyCarRentalSystem.dto.BookingAcceptDTO;
import lk.ijse.easyCarRentalSystem.dto.BookingDTO;
import lk.ijse.easyCarRentalSystem.dto.BookingDetailsDTO;
import lk.ijse.easyCarRentalSystem.entity.*;
import lk.ijse.easyCarRentalSystem.repo.*;
import lk.ijse.easyCarRentalSystem.dto.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    BookingDetailsRepo bookingDetailsRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    DriverScheduleRepo driverScheduleRepo;

    @Autowired
    VehicleScheduleRepo vehicleScheduleRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking(bookingDTO.getBookingID(), "NOT APPROVED", "ON RENT", bookingDTO.getRentDate(), bookingDTO.getRentTime(), bookingDTO.getReturnDate(), bookingDTO.getReturnTime(), bookingDTO.getReturnTime(), bookingDTO.getCustomerNICNumber());

        Booking bookingSaved = bookingRepo.save(booking);

        System.out.println("Update Test" + bookingDTO);

        if (bookingSaved != null) {
            for (BookingDetailsDTO bookingDetailsDTO : bookingDTO.getBookingDetails()) {
                BookingDetails bookingDetails = new BookingDetails(bookingDetailsDTO.getLossDamageFee(), bookingDetailsDTO.getLossDamageFeeSlip().getName(), bookingDetailsDTO.getBookingID(), bookingDetailsDTO.getVehicleRegID(), bookingDetailsDTO.getDriverNICNumber());
                BookingDetails save = bookingDetailsRepo.save(bookingDetails);

                System.out.println("Get VEHICLE ID" + bookingDetailsDTO.getVehicleRegID());

                if (save != null) {
                    Vehicle vehicle = vehicleRepo.findById(bookingDetailsDTO.getVehicleRegID().getVehicleRegID()).get();
                    System.out.println("vehicle = " + vehicle);
                    vehicle.setVehicleStatus("ON USE");
                    Vehicle save1 = vehicleRepo.save(vehicle);
                    System.out.println("SAVE BOOKING STATUS = " + save1);

                    if (save1 != null) {
                        Driver driver = driverRepo.findById(bookingDetailsDTO.getDriverNICNumber().getDriverNICNumber()).get();
                        driver.setDriverStatus("ASSIGN");
                        Driver save2 = driverRepo.save(driver);

                        if (save2 != null) {
                            Driver drivers = driverRepo.findById(bookingDetailsDTO.getDriverNICNumber().getDriverNICNumber()).get();
                            DriverSchedule schedule = new DriverSchedule(bookingDTO.getRentDate(), bookingDTO.getReturnDate(), "ON WORK", drivers);
                            DriverSchedule save3 = driverScheduleRepo.save(schedule);
                            if (save3 != null) {
                                Vehicle vehicle1 = vehicleRepo.findById(bookingDetailsDTO.getVehicleRegID().getVehicleRegID()).get();
                                VehicleSchedule vehicleSchedule = new VehicleSchedule(bookingDTO.getRentDate(), bookingDTO.getRentDate(), "On Travel", vehicle1);
                                VehicleSchedule save4 = vehicleScheduleRepo.save(vehicleSchedule);

                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void updateVehicle(BookingDTO dto) {
        Booking booking = bookingRepo.findById(dto.getBookingID()).get();
        booking.setBookingStatus("REJECTED");
        Booking save = bookingRepo.save(booking);

        if (save != null) {
            for (BookingDetailsDTO bookingDetailsDTO : dto.getBookingDetails()) {
                Vehicle vehicle = vehicleRepo.findById(bookingDetailsDTO.getVehicleRegID().getVehicleRegID()).get();
                System.out.println("vehicle = " + vehicle);
                vehicle.setVehicleStatus("FREE");
                Vehicle save1 = vehicleRepo.save(vehicle);
                if (save1 != null) {
                    Driver drivers = driverRepo.findById(bookingDetailsDTO.getDriverNICNumber().getDriverNICNumber()).get();
                    drivers.setDriverStatus("NOT ASSIGN");
                    driverRepo.save(drivers);
                }
            }
        }
    }

    @Override
    public ArrayList<BookingAcceptDTO> getPendingRent() {
        ArrayList<BookingAcceptDTO> bookingAcceptDTOS = new ArrayList<>();
        List<Booking> all = bookingRepo.getPendingRent();
        System.out.println("all = " + all);

        for (Booking booking : all) {
            bookingAcceptDTOS.add(new BookingAcceptDTO(booking.getBookingID(), booking.getRentDate(), booking.getRentTime(), booking.getReturnDate(), booking.getReturnTime(), booking.getBookingStatus(), booking.getCustomerNICNumber(), booking.getBookingDetails()));
            System.out.println("b.getBookingStatus() = " + booking.getBookingDetails());
        }
        return bookingAcceptDTOS;
    }

    @Override
    public void updatePending(BookingDTO dto) {
        Booking booking = new Booking(dto.getBookingID(), dto.getBookingStatus(), dto.getRentStatus(), dto.getRentDate(), dto.getRentTime(), dto.getReturnStatus(), dto.getReturnDate(), dto.getReturnTime(), dto.getCustomerNICNumber());
    }

    @Override
    public void updateReject(BookingDTO dto) {
        Booking booking = bookingRepo.findById(dto.getBookingID()).get();
        booking.setBookingStatus("REJECTED");
        Booking save = bookingRepo.save(booking);
        if (save != null) {
            for (BookingDetailsDTO bookingDetailsDTO : dto.getBookingDetails()) {
                Vehicle vehicle = vehicleRepo.findById(bookingDetailsDTO.getVehicleRegID().getVehicleRegID()).get();
                vehicle.setVehicleStatus("Free");
                Vehicle save1 = vehicleRepo.save(vehicle);
                if (save1 != null) {
                    Driver drivers = driverRepo.findById(bookingDetailsDTO.getDriverNICNumber().getDriverNICNumber()).get();
                    drivers.setDriverStatus("NOT ASSIGN");
                    driverRepo.save(drivers);
                }
            }
        }
    }

    @Override
    public BookingDTO searchBooking(String bookingID) {
        Optional<Booking> booking = bookingRepo.findById(bookingID);
        if (booking.isPresent()) {
            System.out.println("booking = " + booking);
            return modelMapper.map(booking.get(), BookingDTO.class);
        }
        return null;
    }

    @Override
    public String getLastRid() {
        return bookingRepo.getLastID();
    }
}
