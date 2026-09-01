package com.example.leavemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class auditlog extends BaseEntity {
    
    @Column(nullable = false)
    private String action;
    
    @Column(nullable = false)
    private String entityType;
    
    @Column(nullable = false)
    private Long entityId;
    
    @Column(columnDefinition = "TEXT")
    private String previousValue;
    
    @Column(columnDefinition = "TEXT")
    private String newValue;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private user performedBy;
    
    @Column(nullable = false)
    private LocalDateTime performedAt = LocalDateTime.now();
    
    private String ipAddress;
}


