package com.example.test.demo.service;

import org.springframework.data.domain.Page;

import com.example.test.demo.dto.request.AstronautRequestDto;
import com.example.test.demo.dto.response.AstronautResponseDto;

public interface AstronautService {
    AstronautResponseDto createAstronaut(AstronautRequestDto astronautRequestDto);

    Page<AstronautResponseDto> findAllAstronauts(int page, int pageSize,
            String sortDirection,
            String sortBy);

    AstronautResponseDto updateAstronaut(Long id, AstronautRequestDto astronautRequestDto);
}
