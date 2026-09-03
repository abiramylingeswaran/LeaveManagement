package com.example.leavemanagementsystem.controller;

import com.example.leavemanagementsystem.util.ApiConstants;
import com.example.leavemanagementsystem.dto.RequestDto.HolidayRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.HolidayResponseDto;
import com.example.leavemanagementsystem.service.HolidayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.HOLIDAY_BASE)
@RequiredArgsConstructor
public class HolidayController {

    private final HolidayService holidayService;

    @PostMapping
    public ResponseEntity<HolidayResponseDto> createHoliday(@Valid @RequestBody HolidayRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(holidayService.createHoliday(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HolidayResponseDto> updateHoliday(@PathVariable Long id, @Valid @RequestBody HolidayRequestDto dto) {
        return ResponseEntity.ok(holidayService.updateHoliday(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HolidayResponseDto> getHolidayById(@PathVariable Long id) {
        return ResponseEntity.ok(holidayService.getHolidayById(id));
    }

    @GetMapping
    public ResponseEntity<List<HolidayResponseDto>> getAllHolidays() {
        return ResponseEntity.ok(holidayService.getAllHolidays());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoliday(@PathVariable Long id) {
        holidayService.deleteHoliday(id);
        return ResponseEntity.noContent().build();
    }
}