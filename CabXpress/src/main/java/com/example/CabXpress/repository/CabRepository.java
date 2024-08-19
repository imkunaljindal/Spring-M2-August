package com.example.CabXpress.repository;

import com.example.CabXpress.model.Cab;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CabRepository extends JpaRepository<Cab, Integer> {

    @Query(value = "select * from cab where available = TRUE order by rand() limit 1",nativeQuery = true)
    Cab getRandomAvailableCab();
}
