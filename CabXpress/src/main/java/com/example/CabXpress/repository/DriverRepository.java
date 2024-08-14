package com.example.CabXpress.repository;

import com.example.CabXpress.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Integer> {

    Driver findByMobNo(long mobile);

    List<Driver> findByAgeAndName(int age, String name);
}
