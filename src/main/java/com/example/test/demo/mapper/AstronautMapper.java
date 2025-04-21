package com.example.test.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import com.example.test.demo.domain.Astronaut;
import com.example.test.demo.dto.request.AstronautRequestDto;
import com.example.test.demo.dto.response.AstronautResponseDto;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = SatelliteMapper.class)
public interface AstronautMapper {
        @Mappings({
                        // @Mapping(source = "firstName", target = "firstName"),
                        // @Mapping(source = "lastName", target = "lastName"),
                        // @Mapping(source = "yearsOfExperience", target = "yearsOfExperience"),
                        @Mapping(source = "satellites", target = "satellites")
        })
        Astronaut astronautRequestDtoToAstronaut(AstronautRequestDto astronautRequestDto);

        @Mappings({
                        // @Mapping(source = "firstName", target = "firstName"),
                        // @Mapping(source = "lastName", target = "lastName"),
                        // @Mapping(source = "yearsOfExperience", target = "yearsOfExperience"),
                        @Mapping(source = "satellites", target = "satellites")
        })
        AstronautResponseDto astronautToAstronautResponseDto(Astronaut astronaut);

        @Mappings({
                        // @Mapping(source = "firstName", target = "firstName"),
                        // @Mapping(source = "lastName", target = "lastName"),
                        // @Mapping(source = "yearsOfExperience", target = "yearsOfExperience"),
                        @Mapping(source = "satellites", target = "satellites")
        })
        List<AstronautResponseDto> astronautToAstronautResponseDtoList(List<Astronaut> astronauts);

}
