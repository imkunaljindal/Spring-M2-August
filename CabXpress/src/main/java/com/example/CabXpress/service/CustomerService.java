package com.example.CabXpress.service;

import com.example.CabXpress.Enum.Gender;
import com.example.CabXpress.dto.request.CustomerRequest;
import com.example.CabXpress.dto.response.CustomerResponse;
import com.example.CabXpress.model.Customer;
import com.example.CabXpress.repository.CustomerRepository;
import com.example.CabXpress.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getByGenderAndAgeGreaterThan(gender,age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}
