package com.example.CabXpress.controller;

import com.example.CabXpress.Enum.Gender;
import com.example.CabXpress.dto.request.CustomerRequest;
import com.example.CabXpress.dto.response.CustomerResponse;
import com.example.CabXpress.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {
            CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
            return new ResponseEntity(customerResponse, HttpStatus.CREATED);
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public ResponseEntity getByGenderAndAgeGreaterThan(@PathVariable Gender gender,
                                                       @PathVariable int age) {
        List<CustomerResponse> customerResponses = customerService.getByGenderAndAgeGreaterThan(gender,age);
        return new ResponseEntity(customerResponses,HttpStatus.ACCEPTED);
    }

    // get all customers of a particular gender

    // get all the customers of a particular gender who registered after a particulcar date

    // get all the customers between a particular age (25-40)

    // get customers with highest number of bookings

    // get the customers with lowest number of bookings

}
