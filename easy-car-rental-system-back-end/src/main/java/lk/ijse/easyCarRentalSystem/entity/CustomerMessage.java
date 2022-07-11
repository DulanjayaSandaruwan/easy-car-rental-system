package lk.ijse.easyCarRentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customerNICNumber", referencedColumnName = "customerNICNumber")
    private Customer customerNICNumber;

    public CustomerMessage(String customerEmail, String statusHead, String statusMessage, Customer customerNICNumber) {
        this.customerEmail = customerEmail;
        this.statusHead = statusHead;
        this.statusMessage = statusMessage;
        this.customerNICNumber = customerNICNumber;
    }
}
