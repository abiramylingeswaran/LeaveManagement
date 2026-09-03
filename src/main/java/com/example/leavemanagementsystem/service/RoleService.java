package com.example.leavemanagementsystem.service;

import com.example.leavemanagementsystem.dto.RequestDto.RoleRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.RoleResponseDto;
import java.util.List;

public interface RoleService {
    RoleResponseDto createRole(RoleRequestDto dto);
    RoleResponseDto updateRole(Long id, RoleRequestDto dto);
    RoleResponseDto getRoleById(Long id);
    List<RoleResponseDto> getAllRoles();
    void deleteRole(Long id);
}