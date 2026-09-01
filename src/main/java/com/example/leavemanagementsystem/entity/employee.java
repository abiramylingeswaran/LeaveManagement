package com.example.leavemanagementsystem.entity;

import com.example.leavemanagementsystem.enums.EmploymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class employee extends BaseEntity {
    
    @Column(unique = true, nullable = false)
    private String employeeId;
    
    @Column(nullable = false)
    private String fullName;
    
    private LocalDate dateOfBirth;
    
    private String contactNumber;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    private String address;
    
    private String nic;
    
    @Column(nullable = false)
    private LocalDate joiningDate;
    
    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;
    
    @Column(nullable = false)
    private boolean probation = false;
    
    private String workLocation;
    
    @Column(nullable = false)
    private boolean active = true;
    
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private department department;
    
    @ManyToOne
    @JoinColumn(name = "designation_id")
    private designation designation;
    
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private employee manager;
}

