package lk.ijse.easyCarRentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BookingDetails_PK {
    private String bookingID;
    private String vehicleRegID;
}
