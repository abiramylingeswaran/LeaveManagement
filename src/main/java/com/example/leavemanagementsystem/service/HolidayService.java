package com.example.leavemanagementsystem.service;

import com.example.leavemanagementsystem.dto.RequestDto.HolidayRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.HolidayResponseDto;

import java.util.List;

public interface HolidayService {
    HolidayResponseDto createHoliday(HolidayRequestDto dto);
    HolidayResponseDto updateHoliday(Long id, HolidayRequestDto dto);
    HolidayResponseDto getHolidayById(Long id);
    List<HolidayResponseDto> getAllHolidays();
    void deleteHoliday(Long id); // soft delete (active = false)
}