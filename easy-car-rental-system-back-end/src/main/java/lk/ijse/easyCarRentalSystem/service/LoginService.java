package lk.ijse.easyCarRentalSystem.service;

import lk.ijse.easyCarRentalSystem.dto.CustomerDTO;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
public interface LoginService {
    CustomerDTO matchLoginDetails(String customerEmail, String customerPassword);
}
