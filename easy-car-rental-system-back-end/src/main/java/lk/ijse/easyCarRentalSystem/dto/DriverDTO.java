package lk.ijse.easyCarRentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DriverDTO {

    private String driverNICNumber;

    private MultipartFile driverNICImage;

    private String driverName;

    private String driverEmail;

    private String driverContact;

    private String driverLicenseNumber;

    private MultipartFile driverLicenseImage;

    private String driverPassword;

    private String driverStatus;
}
