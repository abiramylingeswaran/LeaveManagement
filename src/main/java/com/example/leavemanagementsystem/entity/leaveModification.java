package com.example.leavemanagementsystem.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class leaveModification {
    private Long id;
    private LocalDate oldStartDate;
    private LocalDate oldEndDate;
    private LocalDate newStartDate;
    private LocalDate newEndDate;
    private String reason;
//    private ModificationStatus status;
    private LocalDateTime requestedAt;

    private levaerequest leaveRequest;
    private employee requestedBy;
}
