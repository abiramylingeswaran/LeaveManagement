package com.example.leavemanagementsystem.controller;

import com.example.leavemanagementsystem.util.ApiConstants;
import com.example.leavemanagementsystem.dto.RequestDto.PermissionRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.PermissionResponseDto;
import com.example.leavemanagementsystem.service.PermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.PERMISSION_BASE)
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<PermissionResponseDto> create(@Valid @RequestBody PermissionRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(permissionService.createPermission(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionResponseDto> update(@PathVariable Long id, @Valid @RequestBody PermissionRequestDto dto) {
        return ResponseEntity.ok(permissionService.updatePermission(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(permissionService.getPermissionById(id));
    }

    @GetMapping
    public ResponseEntity<List<PermissionResponseDto>> getAll() {
        return ResponseEntity.ok(permissionService.getAllPermissions());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}