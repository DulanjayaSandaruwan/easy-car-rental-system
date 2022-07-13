package lk.ijse.easyCarRentalSystem.dto.service;

import lk.ijse.easyCarRentalSystem.dto.VehicleScheduleDTO;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
public interface VehicleScheduleService {

    ArrayList<VehicleScheduleDTO> searchVehicleSchedule(String vehicleRegID);
}
