package lk.ijse.easyCarRentalSystem.dto;

import lk.ijse.easyCarRentalSystem.entity.Vehicle;
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
public class VehicleScheduleDTO {

    private String scheduleID;

    private String rideStartDate;

    private String rideEndDate;

    private String vehicleStatus;

    private Vehicle vehicleRegID;

    public VehicleScheduleDTO(String rideStartDate, String rideEndDate, String vehicleStatus, Vehicle vehicleRegID) {
        this.rideStartDate = rideStartDate;
        this.rideEndDate = rideEndDate;
        this.vehicleStatus = vehicleStatus;
        this.vehicleRegID = vehicleRegID;
    }
}
