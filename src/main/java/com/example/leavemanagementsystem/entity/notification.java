package com.example.leavemanagementsystem.entity;

import java.time.LocalDateTime;

public class notification {
    private Long id;
    private String title;
    private String message;
//    private NotificationType type;
//    private NotificationChannel channel;
    private boolean read;
    private LocalDateTime createdAt;

    private user user;
}
