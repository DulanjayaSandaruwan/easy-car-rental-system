package lk.ijse.easyCarRentalSystem.controller;

import lk.ijse.easyCarRentalSystem.dto.CustomerDTO;
import lk.ijse.easyCarRentalSystem.exception.NotFoundException;
import lk.ijse.easyCarRentalSystem.service.CustomerService;
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

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) {
        System.out.println("Test1" + " " + dto);
        if (dto.getCustomerNICNumber().trim().length() <= 0) {
            throw new NotFoundException("Customer NIC number can not be empty !");
        }
        customerService.saveCustomer(dto);
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

    @GetMapping(path = "/{customerNICNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomer(@PathVariable String customerNICNumber) {

        System.out.println("Customer ID Search");
        System.out.println("Customer ID Search" + customerNICNumber);

        CustomerDTO customerDTO = customerService.searchCustomer(customerNICNumber);
        return new ResponseEntity(new ResponseUtil("200", "Done", customerDTO), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatePendingRequest(@RequestBody CustomerDTO dto) {
        if (dto.getCustomerNICNumber().trim().length() <= 0) {
            System.out.println("dto = " + dto);
            throw new NotFoundException("No NIC number provided to update");
        }
        customerService.updateCustomerStatus(dto);
        return new ResponseEntity(new ResponseUtil("200", "Done", dto), HttpStatus.OK);
    }
}
