package com.example.test.demo.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.test.demo.domain.Astronaut;
import com.example.test.demo.dto.request.AstronautRequestDto;
import com.example.test.demo.dto.response.AstronautResponseDto;
import com.example.test.demo.exception.astronaut.AstronautNotFoundException;
import com.example.test.demo.exception.astronaut.DuplicateAstronautException;
import com.example.test.demo.mapper.AstronautMapper;
import com.example.test.demo.repository.AstronautRepository;
import com.example.test.demo.service.AstronautService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {
    private final AstronautMapper astronautMapper;
    private final AstronautRepository astronautRepository;

    @Override
    public AstronautResponseDto createAstronaut(@Valid AstronautRequestDto astronautRequestDto) {
        // TODO Auto-generated method stub
        Optional<Astronaut> foundAstronaut = astronautRepository
                .findAstronautByFirstNameAndLastName(astronautRequestDto.firstName(), astronautRequestDto.lastName());
        if (foundAstronaut.isPresent()) {
            throw new DuplicateAstronautException("Astronaut already exists");
        }
        Astronaut astronaut = astronautMapper.astronautRequestDtoToAstronaut(astronautRequestDto);
        Astronaut savedAstronaut = astronautRepository.save(astronaut);
        return astronautMapper.astronautToAstronautResponseDto(savedAstronaut);
    }

    @Override
    public Page<AstronautResponseDto> findAllAstronauts(int page, int pageSize,
            String sortDirection,
            String sortBy) {
        // TODO Auto-generated method stub
        Pageable pageable = PageRequest.of(page,
                pageSize,
                Sort.Direction.fromString(sortDirection),
                sortBy);
        Page<Astronaut> astronautsPage = astronautRepository.findAll(pageable);
        return astronautsPage.map(astronautMapper::astronautToAstronautResponseDto);
    }

    @Override
    public AstronautResponseDto updateAstronaut(Long id, AstronautRequestDto astronautRequestDto) {
        // TODO Auto-generated method stub
        Optional<Astronaut> foundAstronaut = astronautRepository
                .findById(id);
        if (foundAstronaut.isPresent()) {
            Astronaut existingAstronaut = foundAstronaut.get();
            Astronaut mappedAstronaut = astronautMapper.astronautRequestDtoToAstronaut(astronautRequestDto);
            mappedAstronaut.setId(existingAstronaut.getId());
            if (mappedAstronaut.getSatellites() != null) {
                mappedAstronaut.getSatellites().addAll(existingAstronaut.getSatellites());
            }
            Astronaut updatedAstronaut = astronautRepository.save(mappedAstronaut);
            return astronautMapper.astronautToAstronautResponseDto(updatedAstronaut);
        }
        throw new AstronautNotFoundException(
                astronautRequestDto.firstName() + " " + astronautRequestDto.lastName() + " is not found");
    }

}
