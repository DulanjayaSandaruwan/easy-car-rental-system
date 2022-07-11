package lk.ijse.easyCarRentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Customer {

    @Id
    private String customerNICNumber;

    private String customerNICImage;

    private String customerName;

    private String customerAddress;

    private String customerContact;

    private String customerEmail;

    private String customerPassword;

    private String customerDrivingNumber;

    private String customerDrivingImage;

    private String customerStatus;
}
