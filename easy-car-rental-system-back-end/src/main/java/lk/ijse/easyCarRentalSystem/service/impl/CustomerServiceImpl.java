package lk.ijse.easyCarRentalSystem.service.impl;

import lk.ijse.easyCarRentalSystem.dto.CustomerDTO;
import lk.ijse.easyCarRentalSystem.entity.Customer;
import lk.ijse.easyCarRentalSystem.repo.CustomerRepo;
import lk.ijse.easyCarRentalSystem.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Customer customer = new Customer(
                entity.getCustomerNICNumber(),
                entity.getCustomerNICImage(),
                entity.getCustomerName(),
                entity.getCustomerAddress(),
                entity.getCustomerContact(),
                entity.getCustomerEmail(),
                entity.getCustomerPassword(),
                entity.getCustomerDrivingNumber(),
                entity.getCustomerDrivingImage(),
                "Not Approved"
        );
        customerRepo.save(customer);
    }

    public CustomerDTO searchCustomer(String customerNICNumber) {
        Customer customer = customerRepo.findById(customerNICNumber).get();
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
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

    public void updateCustomerStatus(CustomerDTO entity) {
        Customer customer1 = customerRepo.findById(entity.getCustomerNICNumber()).get();
        customer1.setCustomerStatus("Approved");
        customerRepo.save(customer1);
    }
}
