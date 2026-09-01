package com.example.leavemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "leave_policies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeavePolicy extends BaseEntity {
    
    @Column(nullable = false)
    private String name;
    
    private String description;
    
    @Column(nullable = false)
    private int entitlement; // Days per year
    
    private String accumulationMethod; // YEARLY, MONTHLY
    
    @Column(nullable = false)
    private int carryForwardLimit = 0;
    
    @Column(nullable = false)
    private int minimumNoticePeriod = 0; // In days
    
    @Column(nullable = false)
    private int maximumConsecutiveLeave = 365;
    
    @Column(nullable = false)
    private boolean active = true;
    
    @ManyToOne
    @JoinColumn(name = "leave_type_id", nullable = false)
    private LeaveType leaveType;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}

