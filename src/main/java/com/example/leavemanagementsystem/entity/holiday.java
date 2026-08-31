package com.example.leavemanagementsystem.entity;

import java.time.LocalDate;

public class holiday {
    private Long id;
    private String name;
    private LocalDate date;
//    private HolidayType holidayType;
    private boolean workingDay;

    private organization organization;
}
