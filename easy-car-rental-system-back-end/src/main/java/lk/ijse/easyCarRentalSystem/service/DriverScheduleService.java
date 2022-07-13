package lk.ijse.easyCarRentalSystem.dto.service;

import lk.ijse.easyCarRentalSystem.dto.DriverScheduleDTO;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
public interface DriverScheduleService {

    ArrayList<DriverScheduleDTO> searchDriverSchedule(String driverNICNumber);
}
