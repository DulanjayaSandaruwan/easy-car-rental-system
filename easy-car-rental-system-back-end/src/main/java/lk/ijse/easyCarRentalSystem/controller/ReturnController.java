package lk.ijse.easyCarRentalSystem.controller;

import lk.ijse.easyCarRentalSystem.dto.CustomDTO;
import lk.ijse.easyCarRentalSystem.service.DriverService;
import lk.ijse.easyCarRentalSystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 14/07/2022
 **/

@RestController
@RequestMapping("api/v1/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    DriverService driverService;

    @GetMapping(path = "/{vehicleRegID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getReturns(@PathVariable String vehicleRegID) {
        System.out.println("Driver ID Search");
        System.out.println("Vehicle ID Search" + vehicleRegID);

        ArrayList<CustomDTO> bookingDTOS = driverService.getReturn(vehicleRegID);
        return new ResponseEntity(new ResponseUtil("200", "Done", bookingDTOS), HttpStatus.OK);
    }
}
