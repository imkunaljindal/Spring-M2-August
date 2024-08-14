package com.example.CabXpress.controller;

import com.example.CabXpress.dto.request.DriverRequest;
import com.example.CabXpress.dto.response.DriverResponse;
import com.example.CabXpress.model.Driver;
import com.example.CabXpress.service.DriverService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
    public ResponseEntity addDriver(@RequestBody DriverRequest driverRequest) {
        DriverResponse driverResponse = driverService.addDriver(driverRequest);
        return new ResponseEntity(driverResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public DriverResponse getDriver(@RequestParam("driverId") int driverId) {
        return driverService.getDriver(driverId);
    }

    @GetMapping("/mobile/{mobile}")
    public DriverResponse getDriverByMobNo(@PathVariable("mobile") long mobile) {
        return driverService.getByMobNo(mobile);
    }

    @GetMapping("/age-and-name")
    public List<DriverResponse> getDriversByAgeAndName(@RequestParam("age") int age,
                                                       @RequestParam("name") String name) {
        return driverService.getByAgeAndName(age,name);
    }
}
