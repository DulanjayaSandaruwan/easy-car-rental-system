package lk.ijse.easyCarRentalSystem.service;

import lk.ijse.easyCarRentalSystem.dto.VehicleDTO;
import lk.ijse.easyCarRentalSystem.dto.VehicleIDDTO;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
public interface VehicleService {

    void addVehicle(VehicleDTO dto);

    ArrayList<VehicleDTO> getAllVehicle();

    void updateVehicle(VehicleIDDTO dto);

    VehicleDTO getReturns(String vehicleRegID);
}
