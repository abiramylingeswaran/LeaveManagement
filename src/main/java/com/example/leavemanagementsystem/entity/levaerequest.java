package com.example.leavemanagementsystem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class levaerequest {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
//    private LeaveDurationType durationType;
//    private HalfDayType halfDayType;
    private BigDecimal duration;
    private String reason;
//    private LeaveRequestStatus status;
    private LocalDateTime submittedAt;

    private employee employee;
    private leavetype leaveType;

//    private List<LeaveApproval> approvals;
//    private List<Attachment> attachments;
}
