package lk.ijse.easyCarRentalSystem.controller;

import lk.ijse.easyCarRentalSystem.dto.CustomerDTO;
import lk.ijse.easyCarRentalSystem.service.LoginService;
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
@RequestMapping("api/v1/login")
@EnableWebMvc
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping(path = "/{customerEmail}/{customerPassword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity matchLoginDetails(@PathVariable String customerEmail, @PathVariable String customerPassword) {
        System.out.println("Customer Email" + customerEmail);
        System.out.println("Customer Password" + customerPassword);

        CustomerDTO customerDTO = loginService.matchLoginDetails(customerEmail, customerPassword);
        return new ResponseEntity(new ResponseUtil("200", "Done", customerDTO), HttpStatus.OK);
    }
}
