package lk.ijse.easyCarRentalSystem.dto;

import lk.ijse.easyCarRentalSystem.entity.Booking;
import lk.ijse.easyCarRentalSystem.entity.Driver;
import lk.ijse.easyCarRentalSystem.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingDetailsDTO {

    private int bookingDetailsID;

    private double lossDamageFee;

    private MultipartFile lossDamageFeeSlip;

    private Booking bookingID;

    private Vehicle vehicleRegID;

    private Driver driverNICNumber;

}
