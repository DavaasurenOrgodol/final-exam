package com.example.test.demo.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.test.demo.domain.Satellite;
import com.example.test.demo.dto.request.SatelliteRequestDto;
import com.example.test.demo.dto.response.SatelliteResponseDto;
import com.example.test.demo.exception.satellite.DuplicateSatelliteException;
import com.example.test.demo.exception.satellite.SatelliteNotFoundException;
import com.example.test.demo.mapper.SatelliteMapper;
import com.example.test.demo.repository.SatelliteRepository;
import com.example.test.demo.service.SatelliteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {
    private final SatelliteMapper satelliteMapper;
    private final SatelliteRepository satelliteRepository;

    @Override
    public SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto satelliteRequestDto) {
        // TODO Auto-generated method stub
        Optional<Satellite> foundSatellite = satelliteRepository
                .findById(id);
        if (foundSatellite.isPresent()) {
            Satellite existingSatellite = foundSatellite.get();
            Satellite mappedSatellite = satelliteMapper.satelliteRequestDtoToSatellite(satelliteRequestDto);
            mappedSatellite.setId(existingSatellite.getId());

            Satellite updatedSatellite = satelliteRepository.save(mappedSatellite);
            return satelliteMapper.satelliteToSatelliteResponseDto(updatedSatellite);
        }
        throw new SatelliteNotFoundException(
                satelliteRequestDto.name() + " is not found");
    }

    @Override
    public SatelliteResponseDto createSatellite(SatelliteRequestDto satelliteRequestDto) {
        // TODO Auto-generated method stub
        Optional<Satellite> foundSatellite = satelliteRepository.findSatelliteByName(satelliteRequestDto.name());
        if (foundSatellite.isPresent()) {
            throw new DuplicateSatelliteException("Satellite already exists");
        }
        Satellite Satellite = satelliteMapper.satelliteRequestDtoToSatellite(satelliteRequestDto);
        Satellite savedSatellite = satelliteRepository.save(Satellite);
        return satelliteMapper.satelliteToSatelliteResponseDto(savedSatellite);
    }

}
