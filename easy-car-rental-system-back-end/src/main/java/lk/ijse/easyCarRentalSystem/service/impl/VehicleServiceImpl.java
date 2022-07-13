package lk.ijse.easyCarRentalSystem.service.impl;

import lk.ijse.easyCarRentalSystem.dto.VehicleDTO;
import lk.ijse.easyCarRentalSystem.dto.VehicleIDDTO;
import lk.ijse.easyCarRentalSystem.entity.Vehicle;
import lk.ijse.easyCarRentalSystem.exception.ValidateException;
import lk.ijse.easyCarRentalSystem.repo.VehicleRepo;
import lk.ijse.easyCarRentalSystem.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addVehicle(VehicleDTO dto) {
        System.out.println("dto impl = " + dto);
        if (vehicleRepo.existsById(dto.getVehicleRegID())) {
            throw new ValidateException("Customer Already Exist");
        }
        vehicleRepo.save(modelMapper.map(dto, Vehicle.class));
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicle() {
        List<Vehicle> all = vehicleRepo.getNotAssignVehicle();
        System.out.println("Test +  " + all);
        return modelMapper.map(all, new TypeToken<ArrayList<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public void updateVehicle(VehicleIDDTO dto) {

    }

    @Override
    public VehicleDTO getReturns(String vehicleRegID) {
        Vehicle vehicle = vehicleRepo.findByVehicleRegID(vehicleRegID);
        System.out.println("v = " + vehicleRegID);
        return new VehicleDTO(
                vehicle.getVehicleRegID(),
                vehicle.getVehicleBrand(),
                vehicle.getDailyRate(),
                vehicle.getMonthlyRate(),
                vehicle.getFreeKmForDay(),
                vehicle.getFreeKmForMonth(),
                vehicle.getPricePerExtraKm()
        );
    }
}
