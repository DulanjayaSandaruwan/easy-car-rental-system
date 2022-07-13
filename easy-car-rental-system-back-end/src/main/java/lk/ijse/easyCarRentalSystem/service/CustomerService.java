package lk.ijse.easyCarRentalSystem.dto.service;

import lk.ijse.easyCarRentalSystem.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
public interface CustomerService {
    void saveCustomer(CustomerDTO entity);

    CustomerDTO searchCustomer(String customerNICNumber);

    ArrayList<CustomerDTO> getPendingCustomers();

    List<CustomerDTO> getAllCustomers();

    void updateCustomerStatus(CustomerDTO entity);
}
