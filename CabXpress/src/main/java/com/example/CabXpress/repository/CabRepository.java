package com.example.CabXpress.repository;

import com.example.CabXpress.model.Cab;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabRepository extends JpaRepository<Cab, Integer> {
}
