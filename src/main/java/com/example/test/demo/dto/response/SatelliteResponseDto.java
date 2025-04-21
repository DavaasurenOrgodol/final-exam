package com.example.test.demo.dto.response;

import java.util.Date;

import com.example.test.demo.domain.OrbitType;

public record SatelliteResponseDto(
                long id,
                String name,
                Date launch_date,
                OrbitType orbit_type) {

}
