package lk.ijse.easyCarRentalSystem.repo;

import lk.ijse.easyCarRentalSystem.entity.Customer;
import lk.ijse.easyCarRentalSystem.entity.CustomerMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
public interface CustomerMessageRepo extends JpaRepository<CustomerMessage, String> {

    Optional<CustomerMessage> findByCustomerNICNumber( Customer customerNicNumber);
}
