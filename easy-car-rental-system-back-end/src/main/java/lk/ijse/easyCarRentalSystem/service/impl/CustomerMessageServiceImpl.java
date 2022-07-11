package lk.ijse.easyCarRentalSystem.service.impl;

import lk.ijse.easyCarRentalSystem.dto.CustomerDTO;
import lk.ijse.easyCarRentalSystem.dto.CustomerMessageDTO;
import lk.ijse.easyCarRentalSystem.dto.GetCustomerMessageDTO;
import lk.ijse.easyCarRentalSystem.entity.Customer;
import lk.ijse.easyCarRentalSystem.entity.CustomerMessage;
import lk.ijse.easyCarRentalSystem.repo.CustomerMessageRepo;
import lk.ijse.easyCarRentalSystem.repo.CustomerRepo;
import lk.ijse.easyCarRentalSystem.service.CustomerMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
@Service
@Transactional
public class CustomerMessageServiceImpl implements CustomerMessageService {

    @Autowired
    private CustomerMessageRepo customerMessageRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDTO searchCustomers(String customerNICNumber) {
        Optional<Customer> customer = customerRepo.findById(customerNICNumber);
        if (customer.isPresent()) {
            return modelMapper.map(customer.get(), CustomerDTO.class);
        }
        return null;
    }

    @Override
    public CustomerMessageDTO searchCustomersForEmail(GetCustomerMessageDTO getCustomerMessageDTO) {
        Optional<CustomerMessage> byCustNICNumber = customerMessageRepo.findByCustomerNICNumber(getCustomerMessageDTO.getCustomerNICNumber());
        if (byCustNICNumber.isPresent()) {
            return modelMapper.map(byCustNICNumber.get(), CustomerMessageDTO.class);
        }
        return null;
    }

    @Override
    public void addCustomerMessage(CustomerMessageDTO entity) {
        CustomerMessage message = new CustomerMessage(
                entity.getStatusHead(),
                entity.getStatusMessage(),
                entity.getCustomerEmail(),
                entity.getCustomerNicNumber()
        );
        customerMessageRepo.save(message);
    }
}