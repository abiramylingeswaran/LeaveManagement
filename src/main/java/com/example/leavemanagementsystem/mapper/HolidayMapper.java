package com.example.leavemanagementsystem.mapper;

import com.example.leavemanagementsystem.dto.RequestDto.HolidayRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.HolidayResponseDto;
import com.example.leavemanagementsystem.entity.Holiday;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HolidayMapper {

    Holiday toEntity(HolidayRequestDto dto);

    HolidayResponseDto toResponseDto(Holiday entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true) // keep existing value unless updated via DTO
    void updateEntity(@MappingTarget Holiday entity, HolidayRequestDto dto);
}