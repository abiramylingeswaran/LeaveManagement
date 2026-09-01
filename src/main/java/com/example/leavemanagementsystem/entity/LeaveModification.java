package com.example.leavemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "leave_modifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveModification extends BaseEntity {
    
    private LocalDate oldStartDate;
    
    private LocalDate oldEndDate;
    
    private LocalDate newStartDate;
    
    private LocalDate newEndDate;
    
    @Column(nullable = false)
    private String reason;
    
    @Column(nullable = false)
    private String status = "PENDING";
    
    private String comments;
    
    @Column(nullable = false)
    private LocalDateTime requestedAt = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name = "leave_request_id", nullable = false)
    private LevaeRequest leaveRequest;
    
    @ManyToOne
    @JoinColumn(name = "requested_by_id", nullable = false)
    private Employee requestedBy;
}

