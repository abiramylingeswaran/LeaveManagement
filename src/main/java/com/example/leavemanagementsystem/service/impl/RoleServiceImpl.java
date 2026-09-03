package com.example.leavemanagementsystem.service.impl;

import com.example.leavemanagementsystem.dto.RequestDto.RoleRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.RoleResponseDto;
import com.example.leavemanagementsystem.entity.Role;
import com.example.leavemanagementsystem.exceptionHandler.DuplicateResourceException;
import com.example.leavemanagementsystem.exceptionHandler.ResourceNotFoundException;
import com.example.leavemanagementsystem.mapper.RoleMapper;
import com.example.leavemanagementsystem.repository.RoleRepository;
import com.example.leavemanagementsystem.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    @Transactional
    public RoleResponseDto createRole(RoleRequestDto dto) {
        roleRepository.findByName(dto.getName())
                .ifPresent(r -> { throw new DuplicateResourceException("Role already exists: " + dto.getName()); });
        Role role = roleMapper.toEntity(dto);
        role.setActive(true);
        roleMapper.loadPermissions(role, dto.getPermissionIds());
        return roleMapper.toResponseDto(roleRepository.save(role));
    }

    @Override
    @Transactional
    public RoleResponseDto updateRole(Long id, RoleRequestDto dto) {
        Role existing = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found: " + id));
        if (!existing.getName().equals(dto.getName())) {
            roleRepository.findByName(dto.getName())
                    .ifPresent(r -> { throw new DuplicateResourceException("Role already exists: " + dto.getName()); });
        }
        roleMapper.updateEntity(existing, dto);
        roleMapper.loadPermissions(existing, dto.getPermissionIds());
        return roleMapper.toResponseDto(roleRepository.save(existing));
    }

    @Override
    @Transactional(readOnly = true)
    public RoleResponseDto getRoleById(Long id) {
        return roleRepository.findById(id)
                .map(roleMapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleResponseDto> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found: " + id));
        role.setActive(false);
        roleRepository.save(role);
    }
}