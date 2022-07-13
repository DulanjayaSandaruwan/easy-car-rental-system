package lk.ijse.easyCarRentalSystem.repo;

import lk.ijse.easyCarRentalSystem.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/
public interface DriverRepo extends JpaRepository<Driver, String> {

    @Query(value = "select * from driver where driverStatus='NOT ASSIGN'", nativeQuery = true)
    ArrayList<Driver> getNotAssignDrivers();

    @Query(value = "update driver set driverStatus='ASSIGN' where driverNICNumber=?1", nativeQuery = true)
    void updateStatusForDriver(String driverNICNumber);
}
