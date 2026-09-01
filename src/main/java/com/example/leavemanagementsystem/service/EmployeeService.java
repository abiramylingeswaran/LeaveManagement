package com.example.leavemanagementsystem.service;


import com.example.leavemanagementsystem.dto.RequestDto.EmployeeRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.EmployeeResponseDto;

import java.util.List;

/**
 * Service interface for Employee CRUD operations.
 */
public interface EmployeeService {

    /**
     * Create a new employee.
     *
     * @param dto the employee data
     * @return the created employee as response DTO
     */
    EmployeeResponseDto createEmployee(EmployeeRequestDto dto);

    /**
     * Update an existing employee.
     *
     * @param id  the ID of the employee to update
     * @param dto the updated employee data
     * @return the updated employee as response DTO
     */
    EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto dto);

    /**
     * Get an employee by ID.
     *
     * @param id the employee ID
     * @return the employee as response DTO
     */
    EmployeeResponseDto getEmployeeById(Long id);

    /**
     * Get all employees.
     *
     * @return list of all employees as response DTOs
     */
    List<EmployeeResponseDto> getAllEmployees();

    /**
     * Get employees by department ID.
     *
     * @param departmentId the department ID
     * @return list of employees in that department as response DTOs
     */
    List<EmployeeResponseDto> getEmployeesByDepartment(Long departmentId);

    /**
     * Delete (soft delete) an employee.
     *
     * @param id the employee ID
     */
    void deleteEmployee(Long id);
}
