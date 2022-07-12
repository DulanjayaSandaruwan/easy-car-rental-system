package lk.ijse.easyCarRentalSystem.dto;

import lk.ijse.easyCarRentalSystem.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverScheduleDTO {

    private String scheduleID;

    private String rideStartDate;

    private String rideEndDate;

    private String driverStatus;

    private Driver driverNICNumber;

    public DriverScheduleDTO(String rideStartDate, String rideEndDate, String driverStatus, Driver driverNICNumber) {
        this.rideStartDate = rideStartDate;
        this.rideEndDate = rideEndDate;
        this.driverStatus = driverStatus;
        this.driverNICNumber = driverNICNumber;
    }
}
