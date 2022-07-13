package lk.ijse.easyCarRentalSystem.dto.service.impl;

import lk.ijse.easyCarRentalSystem.dto.DriverScheduleDTO;
import lk.ijse.easyCarRentalSystem.dto.service.DriverScheduleService;
import lk.ijse.easyCarRentalSystem.entity.DriverSchedule;
import lk.ijse.easyCarRentalSystem.repo.DriverScheduleRepo;
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
public class DriverScheduleImpl implements DriverScheduleService {

    @Autowired
    DriverScheduleRepo driverScheduleRepo;

    @Override
    public ArrayList<DriverScheduleDTO> searchDriverSchedule(String driverNICNumber) {
        ArrayList<DriverScheduleDTO> list = new ArrayList<>();
        List<DriverSchedule> byDriverNICNumber = driverScheduleRepo.findByDriverNICNumber(driverNICNumber);
        for (DriverSchedule driverSchedule : byDriverNICNumber) {
            list.add(new DriverScheduleDTO(
                    driverSchedule.getRideStartDate(),
                    driverSchedule.getRideEndDate(),
                    driverSchedule.getDriverStatus(),
                    driverSchedule.getDriverNICNumber()
            ));
        }
        return list;
    }
}
