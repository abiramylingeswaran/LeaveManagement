package com.example.leavemanagementsystem.dto.RequestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRequestDto {
    @NotBlank(message = "Permission name is required")
    private String name;
    private String description;
}