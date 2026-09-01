package com.example.leavemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "leave_balances")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveBalance extends BaseEntity {
    
    @Column(nullable = false)
    private BigDecimal entitled = BigDecimal.ZERO;
    
    @Column(nullable = false)
    private BigDecimal used = BigDecimal.ZERO;
    
    @Column(nullable = false)
    private BigDecimal pending = BigDecimal.ZERO;
    
    @Column(nullable = false)
    private BigDecimal available = BigDecimal.ZERO;
    
    @Column(nullable = false)
    private BigDecimal carryForward = BigDecimal.ZERO;
    
    @Column(nullable = false)
    private BigDecimal adjustments = BigDecimal.ZERO;
    
    @Column(nullable = false)
    private int year = LocalDate.now().getYear();
    
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    
    @ManyToOne
    @JoinColumn(name = "leave_type_id", nullable = false)
    private LeaveType leaveType;
    
    @Column(nullable = false)
    private boolean active = true;
}

