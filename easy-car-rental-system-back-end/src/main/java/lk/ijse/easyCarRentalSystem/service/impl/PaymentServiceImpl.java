package lk.ijse.easyCarRentalSystem.service.impl;

import lk.ijse.easyCarRentalSystem.dto.CustomDTO;
import lk.ijse.easyCarRentalSystem.entity.*;
import lk.ijse.easyCarRentalSystem.repo.*;
import lk.ijse.easyCarRentalSystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    BookingDetailsRepo bookingDetailsRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    DriverScheduleRepo driverScheduleRepo;

    @Autowired
    VehicleScheduleRepo vehicleScheduleRepo;

    @Override
    public void addPayment(CustomDTO customDTO) {
        Booking booking = bookingRepo.findById(customDTO.getBookingID()).get();
        Customer customer = customerRepo.findById(customDTO.getCustomerNICNumber()).get();
        Payment payment = new Payment(
                customDTO.getFinalPayment(),
                customer,
                booking
        );
        Payment save = paymentRepo.save(payment);
        if (save != null) {
            Driver driver = driverRepo.findById(customDTO.getDriverNICNumber()).get();
            driver.setDriverStatus("NOT ASSIGN");
            Driver save1 = driverRepo.save(driver);
            if (save1 != null) {
                Vehicle vehicle = vehicleRepo.findById(customDTO.getVehicleRegID()).get();
                vehicle.setVehicleStatus("Free");
                Vehicle save2 = vehicleRepo.save(vehicle);
                if (save2 != null) {
                    Booking booking1 = bookingRepo.findById(customDTO.getBookingID()).get();
                    booking1.setRentStatus("All Done");
                    Booking save3 = bookingRepo.save(booking1);
                    if (save3 != null) {
                        List<DriverSchedule> list = driverScheduleRepo.findByDriverNICNumber(customDTO.getDriverNICNumber());
                        for (DriverSchedule d : list) {
                            DriverSchedule schedule = new DriverSchedule(
                                    d.setDriverStatus("FREE")
                            );
                            driverScheduleRepo.save(schedule);
                        }

                    }
                }
            }

        }
    }
}
