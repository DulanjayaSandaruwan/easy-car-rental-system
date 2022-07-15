package lk.ijse.easyCarRentalSystem.repo;

import lk.ijse.easyCarRentalSystem.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
public interface BookingRepo extends JpaRepository<Booking, String> {

    @Query(value = "select b.bookingID, b.bookingStatus, b.rentStatus, b.rentDate, b.rentTime, b.returnStatus," +
            "b.returnDate, b.returnTime," + "b.customerNICNumber," + "bd.driverNICNumber, bd.vehicleRegID " +
            "from booking b, bookingdetails bd " + "where (b.bookingID = bd.bookingID) " +
            "and b.bookingStatus = 'Not Approved';", nativeQuery = true)
    ArrayList<Booking> getPendingRent();

    @Query(value = "select b.bookingID, b.rentDate, b.rentTime, b.returnDate, b.rentTime, b.customerNICNumber.customerNICNumber, " +
            "bd.lossDamageFee, " + "bd.driverNICNumber.driverNICNumber, bd.vehicleRegID.vehicleRegID from Booking b " +
            "inner join b.bookingDetails bd  where bd.vehicleRegID.vehicleStatus = 'OnUse' " +
            "and bd.vehicleRegID.vehicleRegID = :vehicleRegID")
    ArrayList<Object[]> getReturn(@Param("vehicleRegID") String vehicleRegID);

    @Query(value = "select bookingID from booking order by bookingID desc LIMIT 1", nativeQuery = true)
    String getLastID();
}
