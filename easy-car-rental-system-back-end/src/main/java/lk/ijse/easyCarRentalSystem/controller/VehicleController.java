package lk.ijse.easyCarRentalSystem.controller;

import lk.ijse.easyCarRentalSystem.dto.VehicleDTO;
import lk.ijse.easyCarRentalSystem.dto.VehicleIDDTO;
import lk.ijse.easyCarRentalSystem.exception.NotFoundException;
import lk.ijse.easyCarRentalSystem.service.VehicleService;
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
@RequestMapping("api/v1/vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveVehicle(@ModelAttribute VehicleDTO dto) {
        System.out.println("Test1" + " " + dto);
        if (dto.getVehicleRegID().trim().length() <= 0) {
            throw new NotFoundException("Customer NIC number cannot be empty");
        }
        vehicleService.addVehicle(dto);
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllVehicle() {
        ArrayList<VehicleDTO> allVehicle = vehicleService.getAllVehicle();
        return new ResponseEntity(new ResponseUtil("200", "Done", allVehicle), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDriverStatus(@RequestBody VehicleIDDTO vehicleIDDTO) {
        System.out.println("vehicleIDDTO = " + vehicleIDDTO);
        vehicleService.updateVehicle(vehicleIDDTO);
        return new ResponseEntity(new ResponseUtil("200", "Done", vehicleIDDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/{vehicleRegID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getReturnVehicle(@PathVariable String vehicleRegID) {
        System.out.println("Vehicle ID Search");
        System.out.println("Vehicle ID Search" + vehicleRegID);

        VehicleDTO vehicleDTO = vehicleService.getReturns(vehicleRegID);
        return new ResponseEntity(new ResponseUtil("200", "Done", vehicleDTO), HttpStatus.OK);
    }
}
