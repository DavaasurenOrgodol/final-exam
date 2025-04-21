package com.example.test.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.dto.request.SatelliteRequestDto;
import com.example.test.demo.dto.response.SatelliteResponseDto;
import com.example.test.demo.service.SatelliteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/satellites")
@RequiredArgsConstructor
public class SatelliteController {
    private final SatelliteService satelliteService;

    @PostMapping
    public ResponseEntity<SatelliteResponseDto> createSatellite(
            @Valid @RequestBody SatelliteRequestDto satelliteRequestDto) {
        SatelliteResponseDto SatelliteResponseDto = satelliteService.createSatellite(satelliteRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(SatelliteResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SatelliteResponseDto> updateSatellite(@PathVariable Long id,
            @Valid @RequestBody SatelliteRequestDto satelliteRequestDto) {
        System.out.println("satelite id:" + id);
        SatelliteResponseDto satelliteResponseDto = satelliteService.updateSatellite(id, satelliteRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(satelliteResponseDto);
    }
}
