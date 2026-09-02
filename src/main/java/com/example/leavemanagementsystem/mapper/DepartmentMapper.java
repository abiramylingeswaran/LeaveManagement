package com.example.leavemanagementsystem.mapper;

import com.example.leavemanagementsystem.dto.RequestDto.DepartmentRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.DepartmentResponseDto;
import com.example.leavemanagementsystem.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity (DepartmentRequestDto departmentRequestDto);

    DepartmentResponseDto toResponse (Department department);

    void updateEntity(@MappingTarget Department department, DepartmentMapper responseDto);


}
