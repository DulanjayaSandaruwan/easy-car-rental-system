package lk.ijse.easyCarRentalSystem.repo;

import lk.ijse.easyCarRentalSystem.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
public interface BookingDetailsRepo extends JpaRepository<BookingDetails, String> {

    @Query(value = "select * from bookingdetails where bookingID=?1 ", nativeQuery = true)
    Optional<Objects[]> getBooking(String bookingID);

    @Query(value = "select * from bookingdetails where bookingID=? ", nativeQuery = true)
    List<BookingDetails> findAllByIds(String bookingID);

    @Query("from BookingDetails bd where bd.vehicleRegID.vehicleRegID=:id")
    BookingDetails findByVehicleRegID(@Param("id") String id);
}
