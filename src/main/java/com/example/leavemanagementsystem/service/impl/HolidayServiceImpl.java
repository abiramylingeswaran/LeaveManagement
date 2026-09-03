package com.example.leavemanagementsystem.service.impl;

import com.example.leavemanagementsystem.dto.RequestDto.HolidayRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.HolidayResponseDto;
import com.example.leavemanagementsystem.entity.Holiday;
import com.example.leavemanagementsystem.exceptionHandler.DuplicateResourceException;
import com.example.leavemanagementsystem.exceptionHandler.ResourceNotFoundException;
import com.example.leavemanagementsystem.mapper.HolidayMapper;
import com.example.leavemanagementsystem.repository.HolidayRepository;
import com.example.leavemanagementsystem.service.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HolidayServiceImpl implements HolidayService {

    private final HolidayRepository holidayRepository;
    private final HolidayMapper holidayMapper;

    @Override
    @Transactional
    public HolidayResponseDto createHoliday(HolidayRequestDto dto) {
        // unique constraint: date
        holidayRepository.findByDate(dto.getDate())
                .ifPresent(h -> {
                    throw new DuplicateResourceException("Holiday already exists on date: " + dto.getDate());
                });

        Holiday holiday = holidayMapper.toEntity(dto);
        holiday.setActive(true); // default active
        Holiday saved = holidayRepository.save(holiday);
        return holidayMapper.toResponseDto(saved);
    }

    @Override
    @Transactional
    public HolidayResponseDto updateHoliday(Long id, HolidayRequestDto dto) {
        Holiday existing = holidayRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holiday not found with id: " + id));

        // check unique date if changed
        if (!existing.getDate().equals(dto.getDate())) {
            holidayRepository.findByDate(dto.getDate())
                    .ifPresent(h -> {
                        throw new DuplicateResourceException("Holiday already exists on date: " + dto.getDate());
                    });
        }

        holidayMapper.updateEntity(existing, dto);
        Holiday updated = holidayRepository.save(existing);
        return holidayMapper.toResponseDto(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public HolidayResponseDto getHolidayById(Long id) {
        Holiday holiday = holidayRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holiday not found with id: " + id));
        return holidayMapper.toResponseDto(holiday);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HolidayResponseDto> getAllHolidays() {
        return holidayRepository.findAll().stream()
                .map(holidayMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteHoliday(Long id) {
        Holiday holiday = holidayRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holiday not found with id: " + id));
        holiday.setActive(false);
        holidayRepository.save(holiday);
    }
}