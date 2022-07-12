package lk.ijse.easyCarRentalSystem.repo;

import lk.ijse.easyCarRentalSystem.entity.DriverSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
public interface DriverScheduleRepo extends JpaRepository<DriverSchedule, String> {

    @Query("from DriverSchedule bd where bd.driverNICNumber.driverNICNumber=:driverNICNumber")
    List<DriverSchedule> findByDriverNICNumber(@Param("driverNICNumber") String driverNICNumber);
}
