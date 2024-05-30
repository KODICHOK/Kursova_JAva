package com.example.demo.repository;

import com.example.demo.model.Accumulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccumulationRepository extends JpaRepository<Accumulation, Long> {
}
