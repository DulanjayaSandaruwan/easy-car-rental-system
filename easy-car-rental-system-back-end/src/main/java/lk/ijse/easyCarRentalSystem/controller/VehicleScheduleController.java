package lk.ijse.easyCarRentalSystem.controller;

import lk.ijse.easyCarRentalSystem.dto.VehicleScheduleDTO;
import lk.ijse.easyCarRentalSystem.service.VehicleScheduleService;
import lk.ijse.easyCarRentalSystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@RestController
@RequestMapping("api/v1/vehicleSchedule")
@CrossOrigin
public class VehicleScheduleController {

    @Autowired
    VehicleScheduleService vehicleScheduleService;

    @GetMapping(path = "/{vehicleRegID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getVehicleSchedule(@PathVariable String vehicleRegID) {
        System.out.println("Vehicle RegID Search");
        System.out.println("Vehicle RegID Search" + vehicleRegID);

        ArrayList<VehicleScheduleDTO> customerDTO = vehicleScheduleService.searchVehicleSchedule(vehicleRegID);
        return new ResponseEntity(new ResponseUtil("200", "Done", customerDTO), HttpStatus.OK);
    }
}
