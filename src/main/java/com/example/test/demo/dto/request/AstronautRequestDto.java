package com.example.test.demo.dto.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AstronautRequestDto(
        @NotBlank(message = "first name cannot be blanket/empty/null") String firstName,
        @NotBlank(message = "last name cannot be blanket/empty/null") String lastName,
        double yearsOfExperience,
        @Valid List<SatelliteRequestDto> satellites) {

}
