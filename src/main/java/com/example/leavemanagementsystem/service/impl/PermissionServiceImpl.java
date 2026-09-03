package com.example.leavemanagementsystem.service.impl;

import com.example.leavemanagementsystem.dto.RequestDto.PermissionRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.PermissionResponseDto;
import com.example.leavemanagementsystem.entity.Permission;
import com.example.leavemanagementsystem.exceptionHandler.DuplicateResourceException;
import com.example.leavemanagementsystem.exceptionHandler.ResourceNotFoundException;
import com.example.leavemanagementsystem.mapper.PermissionMapper;
import com.example.leavemanagementsystem.repository.PermissionRepository;
import com.example.leavemanagementsystem.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    @Transactional
    public PermissionResponseDto createPermission(PermissionRequestDto dto) {
        permissionRepository.findByName(dto.getName())
                .ifPresent(p -> { throw new DuplicateResourceException("Permission already exists: " + dto.getName()); });

        Permission permission = permissionMapper.toEntity(dto);
        //permission.setActive(true);
        return permissionMapper.toResponseDto(permissionRepository.save(permission));
    }

    @Override
    @Transactional
    public PermissionResponseDto updatePermission(Long id, PermissionRequestDto dto) {
        Permission existing = permissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found: " + id));

        if (!existing.getName().equals(dto.getName())) {
            permissionRepository.findByName(dto.getName())
                    .ifPresent(p -> { throw new DuplicateResourceException("Permission already exists: " + dto.getName()); });
        }

        permissionMapper.updateEntity(existing, dto);
        return permissionMapper.toResponseDto(permissionRepository.save(existing));
    }

    @Override
    @Transactional(readOnly = true)
    public PermissionResponseDto getPermissionById(Long id) {
        return permissionRepository.findById(id)
                .map(permissionMapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PermissionResponseDto> getAllPermissions() {
        return permissionRepository.findAll().stream()
                .map(permissionMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deletePermission(Long id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found: " + id));
       // permission.setActive(false);
        permissionRepository.save(permission);
    }
}