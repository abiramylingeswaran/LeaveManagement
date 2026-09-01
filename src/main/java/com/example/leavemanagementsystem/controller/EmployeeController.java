package com.example.leavemanagementsystem.controller;


import com.example.leavemanagementsystem.util.ApiConstants;
import com.example.leavemanagementsystem.dto.RequestDto.EmployeeRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.EmployeeResponseDto;
import com.example.leavemanagementsystem.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for Employee CRUD operations.
 * Base URL: /api/employees (defined in ApiConstants)
 */
@RestController
@RequestMapping(ApiConstants.EMPLOYEE_BASE)
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Create a new employee.
     * POST /api/employees
     *
     * @param dto employee data
     * @return created employee with HTTP 201 status
     */
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto dto) {
        EmployeeResponseDto created = employeeService.createEmployee(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Update an existing employee.
     * PUT /api/employees/{id}
     *
     * @param id  employee ID
     * @param dto updated employee data
     * @return updated employee with HTTP 200 status
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDto dto) {
        EmployeeResponseDto updated = employeeService.updateEmployee(id, dto);
        return ResponseEntity.ok(updated);
    }

    /**
     * Get an employee by ID.
     * GET /api/employees/{id}
     *
     * @param id employee ID
     * @return employee details with HTTP 200 status
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {
        EmployeeResponseDto employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    /**
     * Get all employees.
     * GET /api/employees
     *
     * @return list of all employees with HTTP 200 status
     */
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        List<EmployeeResponseDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    /**
     * Get employees by department ID.
     * GET /api/employees/department/{departmentId}
     *
     * @param departmentId department ID
     * @return list of employees in that department with HTTP 200 status
     */
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<EmployeeResponseDto>> getEmployeesByDepartment(@PathVariable Long departmentId) {
        List<EmployeeResponseDto> employees = employeeService.getEmployeesByDepartment(departmentId);
        return ResponseEntity.ok(employees);
    }

    /**
     * Soft delete an employee.
     * DELETE /api/employees/{id}
     *
     * @param id employee ID
     * @return HTTP 204 No Content status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
