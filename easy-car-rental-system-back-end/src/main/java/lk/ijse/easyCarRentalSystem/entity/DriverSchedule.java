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
 * @Since : 12/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class DriverSchedule {

    @Id
    private String scheduleID;

    private String rideStartDate;

    private String rideEndDate;

    private String driverStatus;

    @ManyToOne
    @JoinColumn(name = "driverNICNumber", referencedColumnName = "driverNICNumber")
    private Driver driverNICNumber;

    public DriverSchedule(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public DriverSchedule(String rideStartDate, String rideEndDate, String driverStatus, Driver driverNICNumber) {
        this.rideStartDate = rideStartDate;
        this.rideEndDate = rideEndDate;
        this.driverStatus = driverStatus;
        this.driverNICNumber = driverNICNumber;
    }

    public String setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
        return driverStatus;
    }
}
