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
public class VehicleSchedule {

    @Id
    private String scheduleID;

    private String rideStartDate;

    private String rideEndDate;

    private String vehicleStatus;

    @ManyToOne
    @JoinColumn(name = "vehicleRegID", referencedColumnName = "vehicleRegID")
    private Vehicle vehicleRegID;

    public VehicleSchedule(String rideStartDate, String rideEndDate, String vehicleStatus, Vehicle vehicleRegID) {
        this.rideStartDate = rideStartDate;
        this.rideEndDate = rideEndDate;
        this.vehicleStatus = vehicleStatus;
        this.vehicleRegID = vehicleRegID;
    }
}
