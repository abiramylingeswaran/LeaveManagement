package com.example.leavemanagementsystem.entity;

import java.time.LocalDateTime;

public class leaveApproval {
    private Long id;
//    private ApprovalStatus status;
    private String comments;
    private LocalDateTime actionDate;

    private levaerequest leaveRequest;
    private employee approver;
//    private ApprovalWorkflowStep workflowStep;
}
