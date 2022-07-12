package lk.ijse.easyCarRentalSystem.repo;

import lk.ijse.easyCarRentalSystem.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
public interface PaymentRepo extends JpaRepository<Payment, String> {
}
