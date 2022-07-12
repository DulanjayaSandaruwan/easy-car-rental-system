package lk.ijse.easyCarRentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 11/07/2022
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VehicleDTO {
    private String vehicleRegID;

    private String vehicleBrand;

    private String vehicleColor;

    private String vehicleFrontImage;

    private String vehicleBackImage;

    private String vehicleSideImage;

    private String vehicleInteriorImage;

    private String transmissionType;

    private String fuelType;

    private double lossDamageFee;

    private int noOfPassengers;

    private double dailyRate;

    private double monthlyRate;

    private String freeKmForDay;

    private String freeKmForMonth;

    private double pricePerExtraKm;

    private String vehicleStatus;

    public VehicleDTO(String vehicleRegID) {
        this.vehicleRegID = vehicleRegID;
    }
}
