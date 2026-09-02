package com.example.leavemanagementsystem.service;

import com.example.leavemanagementsystem.dto.RequestDto.DesignationRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.DesignationResponseDto;

import java.util.List;

public interface DesignationService {

    DesignationResponseDto createDesignation(DesignationRequestDto dto);

    DesignationResponseDto updateDesignation(Long id, DesignationRequestDto dto);

    DesignationResponseDto getDesignationById(Long id);

    List<DesignationResponseDto> getAllDesignations();

    List<DesignationResponseDto> getActiveDesignations();

    void deleteDesignation(Long id);
}