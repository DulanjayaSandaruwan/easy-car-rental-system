package lk.ijse.easyCarRentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DriverDTO {

    private String driverNICNumber;

    private String driverNICImage;

    private String driverName;

    private String driverEmail;

    private String driverContact;

    private String driverLicenseNumber;

    private String driverLicenseImage;

    private String driverPassword;

    private String driverStatus;
}
