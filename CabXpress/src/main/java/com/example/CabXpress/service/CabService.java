package com.example.CabXpress.service;

import com.example.CabXpress.exception.DriverNotFoundException;
import com.example.CabXpress.model.Cab;
import com.example.CabXpress.model.Driver;
import com.example.CabXpress.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {

    @Autowired
    DriverRepository driverRepository;

    public String addCab(Cab cab) {
        int driverId = cab.getDriver().getId();
        Optional<Driver> driverOptional =
                driverRepository.findById(driverId);
        if(driverOptional.isEmpty()) {
            throw new DriverNotFoundException("Invalid driver id");
        }

        Driver driver = driverOptional.get();
        cab.setAvailable(true);
        driver.setCab(cab);

        driverRepository.save(driver);
        return "Cab aded";
    }
}
