package com.example.leavemanagementsystem.controller;



import com.example.leavemanagementsystem.util.ApiConstants;
import com.example.leavemanagementsystem.dto.RequestDto.DesignationRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.DesignationResponseDto;
import com.example.leavemanagementsystem.service.DesignationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.DESIGNATION_BASE)
@RequiredArgsConstructor
public class DesignationController {

    private final DesignationService designationService;

    @PostMapping
    public ResponseEntity<DesignationResponseDto> createDesignation(
            @Valid @RequestBody DesignationRequestDto dto) {

        DesignationResponseDto created =
                designationService.createDesignation(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesignationResponseDto> updateDesignation(
            @PathVariable Long id,
            @Valid @RequestBody DesignationRequestDto dto) {

        DesignationResponseDto updated =
                designationService.updateDesignation(id, dto);

        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesignationResponseDto> getDesignationById(
            @PathVariable Long id) {

        DesignationResponseDto designation =
                designationService.getDesignationById(id);

        return ResponseEntity.ok(designation);
    }

    @GetMapping
    public ResponseEntity<List<DesignationResponseDto>>
    getAllDesignations() {

        List<DesignationResponseDto> designations =
                designationService.getAllDesignations();

        return ResponseEntity.ok(designations);
    }

    @GetMapping("/active")
    public ResponseEntity<List<DesignationResponseDto>>
    getActiveDesignations() {

        List<DesignationResponseDto> designations =
                designationService.getActiveDesignations();

        return ResponseEntity.ok(designations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDesignation(
            @PathVariable Long id) {

        designationService.deleteDesignation(id);

        return ResponseEntity.noContent().build();
    }
}