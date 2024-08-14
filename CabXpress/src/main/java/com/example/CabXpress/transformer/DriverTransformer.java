package com.example.CabXpress.transformer;

import com.example.CabXpress.dto.request.DriverRequest;
import com.example.CabXpress.dto.response.DriverResponse;
import com.example.CabXpress.model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest) {
        return Driver.builder()
                .age(driverRequest.getAge())
                .name(driverRequest.getName())
                .mobNo(driverRequest.getMobNo())
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver) {
        return DriverResponse.builder()
                .age(driver.getAge())
                .name(driver.getName())
                .build();
    }
}
