package com.example.leavemanagementsystem.mapper;

import com.example.leavemanagementsystem.dto.RequestDto.RoleRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.RoleResponseDto;
import com.example.leavemanagementsystem.entity.Permission;
import com.example.leavemanagementsystem.entity.Role;
import com.example.leavemanagementsystem.repository.PermissionRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {PermissionRepository.class})
public interface RoleMapper {

    @Autowired
    protected PermissionRepository permissionRepository;

    @Mapping(target = "permissions", ignore = true)
    public abstract Role toEntity(RoleRequestDto dto);

    public abstract RoleResponseDto toResponseDto(Role entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "permissions", ignore = true)
    @Mapping(target = "active", ignore = true)
    public abstract void updateEntity(@MappingTarget Role entity, RoleRequestDto dto);

    // Helper to map permission IDs to Permission entities
    public void loadPermissions(Role role, Set<Long> permissionIds) {
        if (permissionIds != null) {
            Set<Permission> permissions = new HashSet<>();
            permissionIds.forEach(id -> {
                Permission p = permissionRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Permission not found: " + id));
                permissions.add(p);
            });
            role.setPermissions(permissions);
        } else {
            role.setPermissions(new HashSet<>());
        }
    }

    // For response: map Permission to PermissionDto
    protected Set<PermissionDto> mapPermissions(Set<Permission> permissions) {
        return permissions.stream()
                .map(p -> new PermissionDto(p.getId(), p.getName()))
                .collect(Collectors.toSet());
    }
}