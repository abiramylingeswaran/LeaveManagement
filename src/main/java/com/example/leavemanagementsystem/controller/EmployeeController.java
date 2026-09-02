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


@RestController
@RequestMapping(ApiConstants.EMPLOYEE_BASE)
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto dto) {
        EmployeeResponseDto created = employeeService.createEmployee(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDto dto) {
        EmployeeResponseDto updated = employeeService.updateEmployee(id, dto);
        return ResponseEntity.ok(updated);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {
        EmployeeResponseDto employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }


    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        List<EmployeeResponseDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<EmployeeResponseDto>> getEmployeesByDepartment(@PathVariable Long departmentId) {
        List<EmployeeResponseDto> employees = employeeService.getEmployeesByDepartment(departmentId);
        return ResponseEntity.ok(employees);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
