package com.example.leavemanagementsystem.dto.RequestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestDto {
    @NotBlank(message = "Role name is required")
    private String name;
    private String description;
    private Set<Long> permissionIds; // IDs of permissions to assign
}