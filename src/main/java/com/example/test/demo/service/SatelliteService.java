package com.example.test.demo.service;

import com.example.test.demo.dto.request.SatelliteRequestDto;
import com.example.test.demo.dto.response.SatelliteResponseDto;

public interface SatelliteService {
    SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto satelliteRequestDto);

    SatelliteResponseDto createSatellite(SatelliteRequestDto satelliteRequestDto);
}
