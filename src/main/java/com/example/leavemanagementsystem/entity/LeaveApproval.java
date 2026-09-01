package com.example.leavemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "leave_approvals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveApproval extends BaseEntity {
    
    @Column(nullable = false)
    private String status; // APPROVED, REJECTED, PENDING
    
    private String comments;
    
    private LocalDateTime actionDate;
    
    @ManyToOne
    @JoinColumn(name = "leave_request_id", nullable = false)
    private LevaeRequest leaveRequest;
    
    @ManyToOne
    @JoinColumn(name = "approver_id", nullable = false)
    private Employee approver;
    
    @Column(nullable = false)
    private int approvalLevel = 1;
}

