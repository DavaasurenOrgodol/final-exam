package com.example.test.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.test.demo.domain.Satellite;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
    Optional<Satellite> findSatelliteByName(@Param(value = "name") String fistName);
}