package com.example.leavemanagementsystem.entity;

public class leavebalance {
    private Long id;
    private int entitled;
    private int carryForward;
    private int adjustment;
    private int used;
    private int pending;
    private int available;

    private employee employee;
    private leavetype leaveType;
}
