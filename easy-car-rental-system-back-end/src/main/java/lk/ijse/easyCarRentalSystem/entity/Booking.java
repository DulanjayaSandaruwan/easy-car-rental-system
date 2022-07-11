package lk.ijse.easyCarRentalSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
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
public class Booking {

    @Id
    private String bookingID;

    private String bookingStatus;

    private String rentStatus;

    private String rentDate;

    private String rentTime;

    private String returnStatus;

    private String returnDate;

    private String returnTime;

    @ManyToOne
    @JoinColumn(name = "customerNICNumber", referencedColumnName = "customerNICNumber")
    private Customer customerNICNumber;

    @OneToMany(mappedBy = "bookingID")
    @JsonIgnore
    private List<BookingDetails> bookingDetails = new ArrayList<>();

    public Booking(String bookingID, String bookingStatus, String rentDate, String rentTime, String returnDate, String returnTime, Customer customerNICNumber) {
        this.bookingID = bookingID;
        this.bookingStatus = bookingStatus;
        this.rentDate = rentDate;
        this.rentTime = rentTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.customerNICNumber = customerNICNumber;
    }
}
