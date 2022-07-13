package lk.ijse.easyCarRentalSystem.dto.service.impl;

import lk.ijse.easyCarRentalSystem.dto.CustomerDTO;
import lk.ijse.easyCarRentalSystem.entity.Customer;
import lk.ijse.easyCarRentalSystem.repo.CustomerRepo;
import lk.ijse.easyCarRentalSystem.dto.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepo customerRepo;

    public void saveCustomer(CustomerDTO entity) {
        Customer customer = new Customer(entity.getCustomerNICNumber(), entity.getCustomerNICImage().getName(), entity.getCustomerName(), entity.getCustomerAddress(), entity.getCustomerContact(), entity.getCustomerEmail(), entity.getCustomerPassword(), entity.getCustomerDrivingNumber(), entity.getCustomerDrivingImage().getName(), "Not Approved");
        System.out.println(entity.getCustomerNICImage());
        customerRepo.save(customer);
    }

    public CustomerDTO searchCustomer(String customerNICNumber) {
        Optional<Customer> customer = customerRepo.findById(customerNICNumber);
           return modelMapper.map(customer, CustomerDTO.class);
    }

    public ArrayList<CustomerDTO> getPendingCustomers() {
        List<Customer> customers = customerRepo.getPendingCustomers();
        return modelMapper.map(customers, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    public void updateCustomerStatus(CustomerDTO customerNICNumber) {
        Optional<Customer> byId = customerRepo.findById(customerNICNumber.getCustomerNICNumber());
        if(byId.isPresent())
            customerRepo.updateStatusForCustomer(customerNICNumber.getCustomerNICNumber());
    }
}
