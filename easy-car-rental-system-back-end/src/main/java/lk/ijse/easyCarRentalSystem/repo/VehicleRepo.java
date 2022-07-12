package lk.ijse.easyCarRentalSystem.repo;

import lk.ijse.easyCarRentalSystem.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
public interface VehicleRepo extends JpaRepository<Vehicle, String> {

    @Query(value = "update vehicle set vehicleStatus='ASSIGN' where vehicleRegID=?1", nativeQuery = true)
    public void updateStatusForRent(String vehicleRegID);

    @Query(value = "select * from vehicle where vehicleStatus='Free'",nativeQuery = true)
    ArrayList<Vehicle> getNotAssignVehicle();

    @Query("from Vehicle bd where bd.vehicleRegID=:vehicleRegID")
    Vehicle findByVehicleRegID(@Param("vehicleRegID") String vehicleRegID);
}
