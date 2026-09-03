package com.example.leavemanagementsystem.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HolidayResponseDto {
    private Long id;
    private String name;
    private LocalDate date;
    private String holidayType;
    private Boolean workingDay;
    private String description;
    private Boolean active;
}