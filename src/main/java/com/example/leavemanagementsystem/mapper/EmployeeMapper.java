package com.example.leavemanagementsystem.mapper;


import com.example.leavemanagementsystem.dto.RequestDto.EmployeeRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.EmployeeResponseDto;
import com.example.leavemanagementsystem.entity.Department;
import com.example.leavemanagementsystem.entity.Designation;
import com.example.leavemanagementsystem.entity.Employee;
import com.example.leavemanagementsystem.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    // ----- Request -> Entity (for create) -----
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "department", source = "departmentId", qualifiedByName = "mapDepartment")
    @Mapping(target = "designation", source = "designationId", qualifiedByName = "mapDesignation")
    @Mapping(target = "manager", source = "managerId", qualifiedByName = "mapManager")
    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUser")
    Employee toEntity(EmployeeRequestDto dto);

    // ----- Request -> Entity (for update) -----
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "department", source = "departmentId", qualifiedByName = "mapDepartment")
    @Mapping(target = "designation", source = "designationId", qualifiedByName = "mapDesignation")
    @Mapping(target = "manager", source = "managerId", qualifiedByName = "mapManager")
    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUser")
    void updateEntity(@MappingTarget Employee employee, EmployeeRequestDto dto);

    // ----- Entity -> Response -----
    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "departmentName", source = "department.name")
    @Mapping(target = "designationId", source = "designation.id")
    @Mapping(target = "designationName", source = "designation.name")
    @Mapping(target = "managerId", source = "manager.id")
    @Mapping(target = "managerName", source = "manager.fullName")
    @Mapping(target = "userId", source = "user.id")
    EmployeeResponseDto toResponseDto(Employee employee);

    // ----- Helper methods to map ID -> entity reference (proxy) -----
    @Named("mapDepartment")
    default Department mapDepartment(Long id) {
        if (id == null) return null;
        Department d = new Department();
        d.setId(id);
        return d;
    }

    @Named("mapDesignation")
    default Designation mapDesignation(Long id) {
        if (id == null) return null;
        Designation d = new Designation();
        d.setId(id);
        return d;
    }

    @Named("mapManager")
    default Employee mapManager(Long id) {
        if (id == null) return null;
        Employee e = new Employee();
        e.setId(id);
        return e;
    }

    @Named("mapUser")
    default User mapUser(Long id) {
        if (id == null) return null;
        User u = new User();
        u.setId(id);
        return u;
    }
}