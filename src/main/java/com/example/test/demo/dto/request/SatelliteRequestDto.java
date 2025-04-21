package com.example.test.demo.dto.request;

import java.util.Date;

import com.example.test.demo.domain.OrbitType;

public record SatelliteRequestDto(
        String name,
        Date launch_date,
        OrbitType orbit_type) {

}
