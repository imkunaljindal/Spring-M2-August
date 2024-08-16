package com.example.CabXpress.repository;

import com.example.CabXpress.Enum.Gender;
import com.example.CabXpress.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select c from Customer c where c.gender = :gender and c.age >= :age")
    List<Customer> getByGenderAndAgeGreaterThan(Gender gender, int age);
}
