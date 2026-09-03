package com.example.leavemanagementsystem.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseDto {
    private Long id;
    private String name;
    private String description;
    private Boolean active;
    //private Set<PermissionDto> permissions; // nested DTO
}
//
//// simple Permission DTO
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//class PermissionDto {
//    private Long id;
//    private String name;
//}