package lk.ijse.easyCarRentalSystem.dto;

import lk.ijse.easyCarRentalSystem.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 10/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerMessageDTO {

    private String messageID;

    private String customerEmail;

    private String statusHead;

    private String statusMessage;

    private Customer customerNicNumber;
}
