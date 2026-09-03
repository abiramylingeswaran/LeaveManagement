package com.example.leavemanagementsystem.mapper;

import com.example.leavemanagementsystem.dto.RequestDto.PermissionRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.PermissionResponseDto;
import com.example.leavemanagementsystem.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toEntity(PermissionRequestDto dto);
    PermissionResponseDto toResponseDto(Permission entity);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    void updateEntity(@MappingTarget Permission entity, PermissionRequestDto dto);
}