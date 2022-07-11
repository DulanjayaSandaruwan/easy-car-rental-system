package lk.ijse.easyCarRentalSystem.controller;

import lk.ijse.easyCarRentalSystem.dto.CustomerDTO;
import lk.ijse.easyCarRentalSystem.dto.CustomerMessageDTO;
import lk.ijse.easyCarRentalSystem.dto.GetCustomerMessageDTO;
import lk.ijse.easyCarRentalSystem.exception.NotFoundException;
import lk.ijse.easyCarRentalSystem.service.CustomerMessageService;
import lk.ijse.easyCarRentalSystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
@RestController
@CrossOrigin
@RequestMapping("api/v1/customerMessage")
@EnableWebMvc
public class CustomerMessageController {

    @Autowired
    CustomerMessageService customerMessageService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBooking(@RequestBody CustomerMessageDTO customerMessageDTO) {
        System.out.println("dto = " + customerMessageDTO);
        if (customerMessageDTO.getCustomerEmail().trim().length() <= 0) {
            throw new NotFoundException("Customer id cannot be empty");
        }
        customerMessageService.addCustomerMessage(customerMessageDTO);
        return new ResponseEntity(new ResponseUtil("201", "Done", customerMessageDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{customerNICNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomer(@PathVariable String customerNICNumber) {
        System.out.println("customerNICNumber ID Search");
        System.out.println("customerNICNumber ID Search" + customerNICNumber);

        CustomerDTO customerDTO = customerMessageService.searchCustomers(customerNICNumber);
        return new ResponseEntity(new ResponseUtil("200", "Done", customerDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity searchCustomerForEmail(@RequestBody GetCustomerMessageDTO getCustomerMessageDTO) {
        System.out.println("customerNICNumber ID Search");
        System.out.println("customerNICNumber ID Search" + getCustomerMessageDTO);

        CustomerMessageDTO customerDTO = customerMessageService.searchCustomersForEmail(getCustomerMessageDTO);
        return new ResponseEntity(new ResponseUtil("200", "Done", customerDTO), HttpStatus.OK);
    }
}
