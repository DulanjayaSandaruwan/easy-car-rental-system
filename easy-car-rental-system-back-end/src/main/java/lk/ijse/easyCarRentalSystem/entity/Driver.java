package lk.ijse.easyCarRentalSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "driverNICNumber", cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JsonIgnore
    private List<BookingDetails> bookingDetails;

    public Driver(String driverNICNumber, String driverNICImage, String driverName, String driverEmail, String driverContact, String driverLicenseNumber, String driverLicenseImage, String driverPassword, String driverStatus) {
        this.driverNICNumber = driverNICNumber;
        this.driverNICImage = driverNICImage;
        this.driverName = driverName;
        this.driverEmail = driverEmail;
        this.driverContact = driverContact;
        this.driverLicenseNumber = driverLicenseNumber;
        this.driverLicenseImage = driverLicenseImage;
        this.driverPassword = driverPassword;
        this.driverStatus = driverStatus;
    }

}
