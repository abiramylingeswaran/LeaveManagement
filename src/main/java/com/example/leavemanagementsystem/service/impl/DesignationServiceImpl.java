package com.example.leavemanagementsystem.service.impl;


import com.example.leavemanagementsystem.dto.RequestDto.DesignationRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.DesignationResponseDto;
import com.example.leavemanagementsystem.entity.Designation;
import com.example.leavemanagementsystem.mapper.DesignationMapper;
import com.example.leavemanagementsystem.repository.DesignationRepository;
import com.example.leavemanagementsystem.service.DesignationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesignationServiceImpl implements DesignationService {

    private final DesignationRepository designationRepository;
    private final DesignationMapper designationMapper;

    @Override
    public DesignationResponseDto createDesignation(
            DesignationRequestDto dto) {

        Designation designation = designationMapper.toEntity(dto);

        Designation savedDesignation =
                designationRepository.save(designation);

        return designationMapper.toResponse(savedDesignation);
    }

    @Override
    public DesignationResponseDto updateDesignation(
            Long id,
            DesignationRequestDto dto) {

        Designation designation = designationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Designation not found with id: " + id));

        designationMapper.updateEntity(designation, dto);

        Designation updatedDesignation =
                designationRepository.save(designation);

        return designationMapper.toResponse(updatedDesignation);
    }

    @Override
    public DesignationResponseDto getDesignationById(Long id) {

        Designation designation = designationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Designation not found with id: " + id));

        return designationMapper.toResponse(designation);
    }

    @Override
    public List<DesignationResponseDto> getAllDesignations() {

        return designationRepository.findAll()
                .stream()
                .map(designationMapper::toResponse)
                .toList();
    }

    @Override
    public List<DesignationResponseDto> getActiveDesignations() {

        return designationRepository.findByActive(true)
                .stream()
                .map(designationMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteDesignation(Long id) {

        if (!designationRepository.existsById(id)) {
            throw new RuntimeException(
                    "Designation not found with id: " + id);
        }

        designationRepository.deleteById(id);
    }
}
