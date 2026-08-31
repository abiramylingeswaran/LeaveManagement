package com.example.leavemanagementsystem.entity;

public class leavePolicy {
    private Long id;
    private String name;
    private int entitlement;
    private String accumulationMethod;
    private int carryForwardLimit;
    private int minimumNoticePeriod;
    private int maximumConsecutiveLeave;

    private leavetype leaveType;
    private organization organization;
}
