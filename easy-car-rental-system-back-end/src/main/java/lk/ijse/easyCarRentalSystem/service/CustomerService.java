package lk.ijse.easyCarRentalSystem.service;

import lk.ijse.easyCarRentalSystem.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
public interface CustomerService {
    public void saveCustomer(CustomerDTO entity);

    public CustomerDTO searchCustomer(String customerNICNumber);

    public ArrayList<CustomerDTO> getPendingCustomers();

    public List<CustomerDTO> getAllCustomers();

    public void updateCustomerStatus(CustomerDTO entity);
}
