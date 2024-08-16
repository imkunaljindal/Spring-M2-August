package com.example.CabXpress.transformer;

import com.example.CabXpress.dto.request.CustomerRequest;
import com.example.CabXpress.dto.response.CustomerResponse;
import com.example.CabXpress.model.Customer;
import org.springframework.web.bind.annotation.RequestBody;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(@RequestBody CustomerRequest customerRequest) {
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .gender(customer.getGender())
                .registeredOn(customer.getRegisteredOn())
                .build();
    }
}
