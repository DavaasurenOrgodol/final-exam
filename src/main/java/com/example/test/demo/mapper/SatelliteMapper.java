package com.example.test.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.example.test.demo.domain.Satellite;
import com.example.test.demo.dto.request.SatelliteRequestDto;
import com.example.test.demo.dto.response.SatelliteResponseDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SatelliteMapper {
        @Mappings({
                        // @Mapping(source = "id", target = "id"),
                        @Mapping(source = "name", target = "name"),
                        @Mapping(source = "launch_date", target = "launch_date"),
                        @Mapping(source = "orbit_type", target = "orbit_type")
        })
        Satellite satelliteRequestDtoToSatellite(SatelliteRequestDto satelliteRequestDto);

        @Mappings({
                        @Mapping(source = "name", target = "name"),
                        @Mapping(source = "launch_date", target = "launch_date"),
                        @Mapping(source = "orbit_type", target = "orbit_type")
        })
        SatelliteResponseDto satelliteToSatelliteResponseDto(Satellite satellite);

        @Mappings({
                        @Mapping(source = "name", target = "name"),
                        @Mapping(source = "launch_date", target = "launch_date"),
                        @Mapping(source = "orbit_type", target = "orbit_type")
        })
        List<SatelliteResponseDto> productToProductResponseDtoList(List<Satellite> satellites);
}
