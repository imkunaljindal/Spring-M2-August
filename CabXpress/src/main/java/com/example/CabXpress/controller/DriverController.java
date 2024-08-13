package com.example.CabXpress.controller;

import com.example.CabXpress.model.Driver;
import com.example.CabXpress.service.DriverService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
    public String addDriver(@RequestBody Driver driver) {
        return driverService.addDriver(driver);
    }

    @GetMapping
    public Driver getDriver(@RequestParam("driverId") int driverId) {
        return driverService.getDriver(driverId);
    }
}
