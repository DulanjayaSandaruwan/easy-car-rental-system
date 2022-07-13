package lk.ijse.easyCarRentalSystem.dto.service;

import lk.ijse.easyCarRentalSystem.dto.CustomerDTO;
import lk.ijse.easyCarRentalSystem.dto.CustomerMessageDTO;
import lk.ijse.easyCarRentalSystem.dto.GetCustomerMessageDTO;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
public interface CustomerMessageService {

    CustomerDTO searchCustomers(String customerNICNumber);

    CustomerMessageDTO searchCustomersForEmail(GetCustomerMessageDTO getCustomerMessageDTO);

    void addCustomerMessage(CustomerMessageDTO entity);
}
