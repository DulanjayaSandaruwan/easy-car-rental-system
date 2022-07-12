package lk.ijse.easyCarRentalSystem.repo;

import lk.ijse.easyCarRentalSystem.entity.VehicleSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
public interface VehicleScheduleRepo extends JpaRepository<VehicleSchedule, String> {

    @Query("from VehicleSchedule v where v.vehicleRegID.vehicleRegID=:vehicleRegID")
    List<VehicleSchedule> findByVehicleRegID(@Param("vehicleRegID") String vehicleRegID);
}
