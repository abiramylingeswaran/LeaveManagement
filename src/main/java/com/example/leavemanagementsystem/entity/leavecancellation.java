package com.example.leavemanagementsystem.entity;

import java.time.LocalDateTime;

public class leavecancellation {
    private Long id;
    private String reason;
//    private CancellationStatus status;
    private LocalDateTime requestedAt;
    private LocalDateTime approvedAt;

    private levaerequest leaveRequest;
    private employee requestedBy;
    private employee approvedBy;
}
