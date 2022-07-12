package lk.ijse.easyCarRentalSystem.service.impl;

import lk.ijse.easyCarRentalSystem.dto.BookingDetailsDTO;
import lk.ijse.easyCarRentalSystem.dto.CustomDTO;
import lk.ijse.easyCarRentalSystem.dto.DriverDTO;
import lk.ijse.easyCarRentalSystem.entity.BookingDetails;
import lk.ijse.easyCarRentalSystem.entity.Driver;
import lk.ijse.easyCarRentalSystem.repo.BookingDetailsRepo;
import lk.ijse.easyCarRentalSystem.repo.BookingRepo;
import lk.ijse.easyCarRentalSystem.repo.DriverRepo;
import lk.ijse.easyCarRentalSystem.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 12/07/2022
 **/
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private BookingDetailsRepo bookingDetailsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addDrivers(DriverDTO dto) {
        Driver driver = new Driver(dto.getDriverNICNumber(), dto.getDriverNICImage(), dto.getDriverName(), dto.getDriverEmail(), dto.getDriverContact(), dto.getDriverLicenseNumber(), dto.getDriverLicenseImage(), dto.getDriverPassword(), "NOT ASSIGN");
    }

    @Override
    public DriverDTO searchDriver(String driverNICNumber) {
        Optional<Driver> driver = driverRepo.findById(driverNICNumber);
        if (driver.isPresent()){
            return modelMapper.map(driver.get(), DriverDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<DriverDTO> getNotAssignDrivers() {
        List<Driver> allDriver = driverRepo.findAll();

        return modelMapper.map(allDriver, new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }

    @Override
    public BookingDetailsDTO getReturns(String vehicleRegID) {
        BookingDetails bookingDetails = bookingDetailsRepo.findByVehicleRegID(vehicleRegID);
        return new BookingDetailsDTO(
                bookingDetails.getBookingDetailsID(),
                bookingDetails.getLossDamageFee(),
                bookingDetails.getLossDamageFeeSlip(),
                bookingDetails.getBookingID(),
                bookingDetails.getVehicleRegID(),
                bookingDetails.getDriverNICNumber()
        );
    }

    @Override
    public ArrayList<CustomDTO> getReturn(String vehicleRegID) {
        ArrayList<Object[]> arrayList = bookingRepo.getReturn(vehicleRegID);
        ArrayList<CustomDTO> all = new ArrayList<>();
        for (Object[] object : arrayList){
            System.out.println(Arrays.toString(object));
            all.add(new CustomDTO(
                    object[0].toString(),
                    object[1].toString(),
                    object[2].toString(),
                    object[3].toString(),
                    Double.parseDouble(object[4].toString()),
                    object[5].toString(),
                    object[6].toString()
            ));
        }
        System.out.println("Final = " + arrayList);
        return all;
    }

    @Override
    public void updateDriverStatus(DriverDTO driverNICNumber) {
        Driver byId = driverRepo.findById(driverNICNumber.getDriverNICImage()).get();
        byId.setDriverStatus("ASSIGN");
        driverRepo.save(byId);
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        List<Driver> allDrivers = driverRepo.findAll();
        return modelMapper.map(allDrivers, new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }
}
