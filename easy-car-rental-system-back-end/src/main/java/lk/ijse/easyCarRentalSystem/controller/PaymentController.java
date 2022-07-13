package lk.ijse.easyCarRentalSystem.controller;

import lk.ijse.easyCarRentalSystem.dto.CustomDTO;
import lk.ijse.easyCarRentalSystem.exception.NotFoundException;
import lk.ijse.easyCarRentalSystem.dto.service.CustomerMessageService;
import lk.ijse.easyCarRentalSystem.dto.service.PaymentService;
import lk.ijse.easyCarRentalSystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@RestController
@RequestMapping("api/v1/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    CustomerMessageService customerMessageService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBooking(@RequestBody CustomDTO dto) {
        System.out.println("dto = " + dto);
        if (dto.getVehicleRegID().trim().length() <= 0) {
            throw new NotFoundException("Booking id cannot be empty");
        }
        paymentService.addPayment(dto);
        return new ResponseEntity(new ResponseUtil("200", "Done", dto), HttpStatus.CREATED);
    }

}
