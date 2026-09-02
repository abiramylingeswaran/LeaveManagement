// EmployeeRequestDto.java
package com.example.leavemanagementsystem.dto.RequestDto;

import com.example.leavemanagementsystem.enums.EmploymentType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {

    @NotBlank(message = "Employee ID is required")
    private String employeeId;

    @NotBlank(message = "Full name is required")
    private String fullName;

    private LocalDate dateOfBirth;

    private String contactNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    private String address;

    private String nic;

    @NotNull(message = "Joining date is required")
    private LocalDate joiningDate;

    private EmploymentType employmentType;

    private Boolean probation = false;

    private String workLocation;

    private Boolean active = true;

    private Long userId;
    private Long departmentId;
    private Long designationId;
    private Long managerId;
}