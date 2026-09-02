package com.example.leavemanagementsystem.mapper;

import com.example.leavemanagementsystem.dto.RequestDto.EmployeeRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.EmployeeResponseDto;
import com.example.leavemanagementsystem.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeRequestDto dto);

    EmployeeResponseDto toResponseDto(Employee employee);

    void updateEntity(@MappingTarget Employee employee, EmployeeRequestDto dto);
}