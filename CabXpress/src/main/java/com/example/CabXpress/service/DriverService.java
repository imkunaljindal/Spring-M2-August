package com.example.CabXpress.service;

import com.example.CabXpress.exception.DriverNotFoundException;
import com.example.CabXpress.model.Cab;
import com.example.CabXpress.model.Driver;
import com.example.CabXpress.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public String addDriver(Driver driver) {
        driverRepository.save(driver); // save driver + cab
        return "Driver and Cab registered";
    }

    public Driver getDriver(int driverId) {
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()) {
            throw new DriverNotFoundException("Invalid driver id");
        }
        return optionalDriver.get();
    }
}
