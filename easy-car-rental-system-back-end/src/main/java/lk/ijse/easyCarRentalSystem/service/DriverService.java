package lk.ijse.easyCarRentalSystem.service;

import lk.ijse.easyCarRentalSystem.dto.BookingDetailsDTO;
import lk.ijse.easyCarRentalSystem.dto.CustomDTO;
import lk.ijse.easyCarRentalSystem.dto.DriverDTO;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/
public interface DriverService {
    void addDrivers(DriverDTO dto);

    DriverDTO searchDriver(String driverNICNumber);

    ArrayList<DriverDTO> getNotAssignDrivers();

    BookingDetailsDTO getReturns(String vehicleRegID);

    ArrayList<CustomDTO> getReturn(String vehicleRegID);
    void updateDriverStatus(DriverDTO driverNICNumber);

    ArrayList<DriverDTO>getAllDrivers();
}
