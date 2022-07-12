package lk.ijse.easyCarRentalSystem.service.impl;

import lk.ijse.easyCarRentalSystem.dto.VehicleScheduleDTO;
import lk.ijse.easyCarRentalSystem.entity.VehicleSchedule;
import lk.ijse.easyCarRentalSystem.repo.VehicleScheduleRepo;
import lk.ijse.easyCarRentalSystem.service.VehicleScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@Service
@Transactional
public class VehicleScheduleServiceImpl implements VehicleScheduleService {

    @Autowired
    VehicleScheduleRepo vehicleScheduleRepo;

    @Override
    public ArrayList<VehicleScheduleDTO> searchVehicleSchedule(String vehicleRegID) {
        ArrayList<VehicleScheduleDTO> list = new ArrayList<>();
        List<VehicleSchedule> byVehicleRegID = vehicleScheduleRepo.findByVehicleRegID(vehicleRegID);
        for (VehicleSchedule vehicleSchedule : byVehicleRegID) {
            list.add(new VehicleScheduleDTO(
                    vehicleSchedule.getRideStartDate(),
                    vehicleSchedule.getRideEndDate(),
                    vehicleSchedule.getVehicleStatus(),
                    vehicleSchedule.getVehicleRegID()
            ));
        }
        return list;
    }
}
