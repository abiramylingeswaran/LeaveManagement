package com.example.leavemanagementsystem.entity;

import com.example.leavemanagementsystem.enums.HalfDayType;
import com.example.leavemanagementsystem.enums.LeaveRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "leave_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class levaerequest extends BaseEntity {
    
    @Column(nullable = false)
    private LocalDate startDate;
    
    @Column(nullable = false)
    private LocalDate endDate;
    
    @Column(nullable = false)
    private boolean halfDay = false;
    
    @Enumerated(EnumType.STRING)
    private HalfDayType halfDayType;
    
    @Column(nullable = false)
    private BigDecimal duration = BigDecimal.ZERO;
    
    @Column(nullable = false)
    private String reason;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LeaveRequestStatus status = LeaveRequestStatus.PENDING;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime submittedAt = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private employee employee;
    
    @ManyToOne
    @JoinColumn(name = "leave_type_id", nullable = false)
    private leavetype leaveType;
    
    @OneToMany(mappedBy = "leaveRequest", cascade = CascadeType.ALL)
    private List<leaveApproval> approvals = new ArrayList<>();
    
    @OneToMany(mappedBy = "leaveRequest", cascade = CascadeType.ALL)
    private List<attachment> attachments = new ArrayList<>();
}

