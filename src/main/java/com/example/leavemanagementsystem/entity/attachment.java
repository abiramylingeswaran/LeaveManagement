package com.example.leavemanagementsystem.entity;

import java.time.LocalDateTime;

public class attachment {
    private Long id;
    private String fileName;
    private String filePath;
    private String fileType;
    private Long fileSize;
    private LocalDateTime uploadedAt;

    private levaerequest leaveRequest;
    private employee uploadedBy;
}
