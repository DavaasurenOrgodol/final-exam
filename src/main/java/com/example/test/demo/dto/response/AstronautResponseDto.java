package com.example.test.demo.dto.response;

import java.util.List;

public record AstronautResponseDto(
        long id,
        String firstName,
        String lastName,
        double yearsOfExperience,
        List<SatelliteResponseDto> satellites) {

}
