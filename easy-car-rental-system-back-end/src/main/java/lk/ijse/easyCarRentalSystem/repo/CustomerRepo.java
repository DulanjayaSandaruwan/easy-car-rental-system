package lk.ijse.easyCarRentalSystem.repo;

import lk.ijse.easyCarRentalSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query(value = "select * from customer where customerStatus='Not Approved'", nativeQuery = true)

    public ArrayList<Customer> getPendingCustomers();
}
