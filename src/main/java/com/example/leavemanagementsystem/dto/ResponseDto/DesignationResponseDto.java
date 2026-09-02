package com.example.leavemanagementsystem.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignationResponseDto {

    private Long id;

    private String name;

    private String description;

    private boolean active;
}