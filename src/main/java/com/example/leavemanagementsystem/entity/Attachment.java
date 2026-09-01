package com.example.leavemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "attachments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment extends BaseEntity {
    
    @Column(nullable = false)
    private String fileName;
    
    @Column(nullable = false)
    private String filePath;
    
    @Column(nullable = false)
    private String fileType;
    
    @Column(nullable = false)
    private long fileSize;
    
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "leave_request_id", nullable = false)
    private LevaeRequest leaveRequest;
    
    @ManyToOne
    @JoinColumn(name = "uploaded_by_id")
    private Employee uploadedBy;
    
    @Column(nullable = false)
    private LocalDateTime uploadedAt = LocalDateTime.now();
}

