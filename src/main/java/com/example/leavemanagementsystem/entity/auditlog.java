package com.example.leavemanagementsystem.entity;

import java.time.LocalDateTime;

public class auditlog {
    private Long id;
//    private AuditAction action;
    private LocalDateTime dateTime;
    private String affectedRecord;
    private String previousValue;
    private String newValue;

    private user user;
}
