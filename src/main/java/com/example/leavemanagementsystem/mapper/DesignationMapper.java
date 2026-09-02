package com.example.leavemanagementsystem.mapper;

import com.example.leavemanagementsystem.dto.RequestDto.DesignationRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.DesignationResponseDto;
import com.example.leavemanagementsystem.entity.Designation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DesignationMapper {

    Designation toEntity(DesignationRequestDto designationRequestDto);

    DesignationResponseDto toResponse(Designation designation);

    void updateEntity(
            @MappingTarget Designation designation,
            DesignationRequestDto requestDto
    );
}