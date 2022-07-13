package lk.ijse.easyCarRentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

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

    private MultipartFile vehicleFrontImage;

    private MultipartFile vehicleBackImage;

    private MultipartFile vehicleSideImage;

    private MultipartFile vehicleInteriorImage;

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

    public VehicleDTO(String vehicleRegID, String vehicleBrand, double dailyRate, double monthlyRate, String freeKmForDay, String freeKmForMonth, double pricePerExtraKm) {
        this.vehicleRegID = vehicleRegID;
    }
}
