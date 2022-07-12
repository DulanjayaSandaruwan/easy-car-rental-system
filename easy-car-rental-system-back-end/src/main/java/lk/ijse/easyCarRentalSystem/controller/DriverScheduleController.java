package lk.ijse.easyCarRentalSystem.controller;

import lk.ijse.easyCarRentalSystem.dto.DriverScheduleDTO;
import lk.ijse.easyCarRentalSystem.service.DriverScheduleService;
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
@RequestMapping("api/v1/driverSchedule")
@CrossOrigin
public class DriverScheduleController {

    @Autowired
    DriverScheduleService driverScheduleService;

    @GetMapping(path = "/{driverNICNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDriverShedule(@PathVariable String driverNICNumber) {
        System.out.println("Driver ID Search");
        System.out.println("Driver ID Search" + driverNICNumber);

        ArrayList<DriverScheduleDTO> customerDTO = driverScheduleService.searchDriverSchedule(driverNICNumber);
        return new ResponseEntity(new ResponseUtil("200", "Done", customerDTO), HttpStatus.OK);
    }
}
