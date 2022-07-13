package lk.ijse.easyCarRentalSystem.controller;

import lk.ijse.easyCarRentalSystem.dto.DriverDTO;
import lk.ijse.easyCarRentalSystem.exception.NotFoundException;
import lk.ijse.easyCarRentalSystem.service.DriverService;
import lk.ijse.easyCarRentalSystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@RestController
@RequestMapping("api/v1/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCustomer(@ModelAttribute DriverDTO dto) {
        System.out.println("Test1" + " " + dto);
        if (dto.getDriverNICNumber().trim().length() <= 0) {
            throw new NotFoundException("Customer id cannot be empty");
        }
        driverService.addDrivers(dto);
        return new ResponseEntity(new ResponseUtil("200", "Done", dto), HttpStatus.CREATED);
    }

    @PostMapping("/file")
    public ResponseEntity saveFile(@RequestPart("file") MultipartFile myFile) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();
            System.out.println("projectPath = " + projectPath);
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));

            return new ResponseEntity(new ResponseUtil("200", "Done", myFile.getOriginalFilename()), HttpStatus.OK);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity(new ResponseUtil("500", "Done", false), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            return new ResponseEntity(new ResponseUtil("500", "Done", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{driverNICNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchDrivers(@PathVariable String driverNICNumber) {
        System.out.println("Driver ID Search");
        System.out.println("Drive ID Search" + driverNICNumber);

        DriverDTO driverDTO = driverService.searchDriver(driverNICNumber);
        return new ResponseEntity(new ResponseUtil("200", "Done", driverDTO), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getNotAssignDrivers() {
        ArrayList<DriverDTO> allDrivers = driverService.getNotAssignDrivers();
        System.out.println("allDrivers = " + allDrivers);
        return new ResponseEntity(new ResponseUtil("200", "Done", allDrivers), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDriverStatus(@RequestBody DriverDTO driverDTO) {
        driverService.updateDriverStatus(driverDTO);
        return new ResponseEntity(new ResponseUtil("200", "Done", driverDTO), HttpStatus.OK);
    }

    @GetMapping("allDrivers")
    public ResponseEntity getAllDrivers() {
        ArrayList<DriverDTO> allDrivers = driverService.getAllDrivers();
        return new ResponseEntity(new ResponseUtil("200", "Done", allDrivers), HttpStatus.OK);
    }
}
