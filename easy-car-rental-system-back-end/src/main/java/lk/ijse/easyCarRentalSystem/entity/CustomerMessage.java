package lk.ijse.easyCarRentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class CustomerMessage {

    @Id
    private String messageID;

    private String customerEmail;

    private String statusHead;

    private String statusMessage;

    @ManyToOne
    @JoinColumn(name = "customerNICNumber", referencedColumnName = "customerNICNumber")
    private Customer customerNicNumber;

    public CustomerMessage(String customerEmail, String statusHead, String statusMessage, Customer customerNicNumber) {
        this.customerEmail = customerEmail;
        this.statusHead = statusHead;
        this.statusMessage = statusMessage;
        this.customerNicNumber = customerNicNumber;
    }
}
