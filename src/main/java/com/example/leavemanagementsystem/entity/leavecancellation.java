package com.example.leavemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "leave_cancellations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class leavecancellation extends BaseEntity {
    
    @Column(nullable = false)
    private String reason;
    
    @Column(nullable = false)
    private String status = "PENDING";
    
    private String comments;
    
    @Column(nullable = false)
    private LocalDateTime requestedAt = LocalDateTime.now();
    
    private LocalDateTime approvedAt;
    
    @ManyToOne
    @JoinColumn(name = "leave_request_id", nullable = false)
    private levaerequest leaveRequest;
    
    @ManyToOne
    @JoinColumn(name = "requested_by_id", nullable = false)
    private employee requestedBy;
    
    @ManyToOne
    @JoinColumn(name = "approved_by_id")
    private employee approvedBy;
}

