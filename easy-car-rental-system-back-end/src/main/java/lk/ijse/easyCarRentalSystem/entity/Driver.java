package lk.ijse.easyCarRentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Driver {

    @Id
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
