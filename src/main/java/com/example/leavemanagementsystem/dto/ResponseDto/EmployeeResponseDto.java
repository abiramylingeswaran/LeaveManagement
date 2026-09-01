package com.example.leavemanagementsystem.dto.ResponseDto;
import com.example.leavemanagementsystem.enums.EmploymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {

    private Long id;
    private String employeeId;
    private String fullName;
    private LocalDate dateOfBirth;
    private String contactNumber;
    private String email;
    private String address;
    private String nic;
    private LocalDate joiningDate;
    private EmploymentType employmentType;
    private Boolean probation;
    private String workLocation;
    private Boolean active;

    // Related entity info (IDs and display names)
    private Long userId;
    private Long departmentId;
    private String departmentName;
    private Long designationId;
    private String designationName;
    private Long managerId;
    private String managerName;
}