package com.example.test.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.dto.request.AstronautRequestDto;
import com.example.test.demo.dto.response.AstronautResponseDto;
import com.example.test.demo.service.AstronautService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/astronauts")
@RequiredArgsConstructor
public class AstronautController {
    private final AstronautService astronautService;

    @PostMapping
    public ResponseEntity<AstronautResponseDto> createAstronaut(
            @Valid @RequestBody AstronautRequestDto astronautRequestDto) {
        AstronautResponseDto astronautResponseDto = astronautService.createAstronaut(astronautRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(astronautResponseDto);
    }

    @PutMapping
    public ResponseEntity<AstronautResponseDto> updateAstronaut(@PathVariable Long id,
            @Valid @RequestBody AstronautRequestDto astronautRequestDto) {
        AstronautResponseDto astronautResponseDto = astronautService.updateAstronaut(id, astronautRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(astronautResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<AstronautResponseDto>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {

        Page<AstronautResponseDto> astronautResponseDtos = astronautService.findAllAstronauts(page,
                pageSize, sortDirection,
                sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(astronautResponseDtos);
    }
}
