package com.example.leavemanagementsystem.dto.RequestDto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignationRequestDto {

    private String name;

    private String description;

    private boolean active = true;
}