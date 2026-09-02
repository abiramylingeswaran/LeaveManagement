package com.example.leavemanagementsystem.service;

import com.example.leavemanagementsystem.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Department saveDepartment(Department dept);

    Optional<Department> getDepartmentById(Long id);

    Optional<Department> getDepartmentByName(String name);

    List<Department> getAllActiveDepartments();

    List<Department> getAllDepartments();

    void deleteDepartment(Long id);
}