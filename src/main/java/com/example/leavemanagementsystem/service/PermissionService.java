package com.example.leavemanagementsystem.service;

import com.example.leavemanagementsystem.dto.RequestDto.PermissionRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.PermissionResponseDto;

import java.util.List;

public interface PermissionService {
    PermissionResponseDto createPermission(PermissionRequestDto dto);
    PermissionResponseDto updatePermission(Long id, PermissionRequestDto dto);
    PermissionResponseDto getPermissionById(Long id);
    List<PermissionResponseDto> getAllPermissions();
    void deletePermission(Long id);
}