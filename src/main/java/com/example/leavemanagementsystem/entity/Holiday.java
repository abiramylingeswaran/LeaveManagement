package com.example.leavemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "holidays")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Holiday extends BaseEntity {
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private LocalDate date;
    
    private String holidayType; // PUBLIC, COMPANY, SPECIAL
    
    @Column(nullable = false)
    private boolean workingDay = false;
    
    private String description;
    
    @Column(nullable = false)
    private boolean active = true;
}

