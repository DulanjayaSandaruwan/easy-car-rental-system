package lk.ijse.easyCarRentalSystem.service.impl;

import lk.ijse.easyCarRentalSystem.dto.CustomerDTO;
import lk.ijse.easyCarRentalSystem.entity.Customer;
import lk.ijse.easyCarRentalSystem.repo.LoginRepo;
import lk.ijse.easyCarRentalSystem.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CustomerDTO matchLoginDetails(String customerEmail, String customerPassword) {
        Customer customer = loginRepo.findCustomerByCustomerEmailAndAndCustomerPassword(customerEmail, customerPassword).get();
        return modelMapper.map(customer.getCustomerEmail(), CustomerDTO.class);
    }
}
