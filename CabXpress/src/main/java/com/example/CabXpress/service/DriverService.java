package com.example.CabXpress.service;

import com.example.CabXpress.dto.request.DriverRequest;
import com.example.CabXpress.dto.response.DriverResponse;
import com.example.CabXpress.exception.DriverNotFoundException;
import com.example.CabXpress.model.Cab;
import com.example.CabXpress.model.Driver;
import com.example.CabXpress.repository.DriverRepository;
import com.example.CabXpress.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest) {
        // req -> entity
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        //save
        Driver savedDriver = driverRepository.save(driver);
        // entity -> response
        return DriverTransformer.driverToDriverResponse(savedDriver);
    }

    public DriverResponse getDriver(int driverId) {
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()) {
            throw new DriverNotFoundException("Invalid driver id");
        }
        Driver driver = optionalDriver.get();
        return DriverTransformer.driverToDriverResponse(driver);

    }

    public DriverResponse getByMobNo(long mobile) {
        Driver driver = driverRepository.findByMobNo(mobile);
        if(ObjectUtils.isEmpty(driver)) {
            throw new DriverNotFoundException("Invalid mobile no");
        }
        return DriverTransformer.driverToDriverResponse(driver);
    }

    public List<DriverResponse> getByAgeAndName(int age,
                                                String name) {
        List<Driver> drivers = driverRepository.findByAgeAndName(age,name);
        List<DriverResponse> driverResponses = new ArrayList<>();
        for(Driver driver: drivers) {
            driverResponses.add(DriverTransformer.driverToDriverResponse(driver));
        }
        return driverResponses;
    }
}
