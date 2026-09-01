package com.example.leavemanagementsystem.service.impl;

import com.example.leavemanagementsystem.dto.RequestDto.EmployeeRequestDto;
import com.example.leavemanagementsystem.dto.ResponseDto.EmployeeResponseDto;
import com.example.leavemanagementsystem.entity.Department;
import com.example.leavemanagementsystem.entity.Designation;
import com.example.leavemanagementsystem.entity.Employee;
import com.example.leavemanagementsystem.entity.User;
import com.example.leavemanagementsystem.exceptionHandler.DuplicateResourceException;
import com.example.leavemanagementsystem.exceptionHandler.ResourceNotFoundException;
import com.example.leavemanagementsystem.mapper.EmployeeMapper;
import com.example.leavemanagementsystem.repository.DepartmentRepository;
import com.example.leavemanagementsystem.repository.DesignationRepository;
import com.example.leavemanagementsystem.repository.EmployeeRepository;
import com.example.leavemanagementsystem.repository.UserRepository;
import com.example.leavemanagementsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link EmployeeService}.
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final DesignationRepository designationRepository;
    private final UserRepository userRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    @Transactional
    public EmployeeResponseDto createEmployee(EmployeeRequestDto dto) {
        validateUniqueConstraints(dto, null);

        Employee employee = employeeMapper.toEntity(dto);
        loadReferences(employee, dto);

        Employee saved = employeeRepository.save(employee);
        return employeeMapper.toResponseDto(saved);
    }

    @Override
    @Transactional
    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto dto) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        validateUniqueConstraints(dto, existing);

        employeeMapper.updateEntity(existing, dto);
        loadReferences(existing, dto);

        Employee updated = employeeRepository.save(existing);
        return employeeMapper.toResponseDto(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return employeeMapper.toResponseDto(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponseDto> getEmployeesByDepartment(Long departmentId) {
        if (!departmentRepository.existsById(departmentId)) {
            throw new ResourceNotFoundException("Department not found with id: " + departmentId);
        }
        return employeeRepository.findByDepartmentId(departmentId).stream()
                .map(employeeMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employee.setActive(false);
        employeeRepository.save(employee);
    }

    // ---- Helper methods ----

    private void validateUniqueConstraints(EmployeeRequestDto dto, Employee existing) {
        employeeRepository.findByEmployeeId(dto.getEmployeeId())
                .ifPresent(e -> {
                    if (existing == null || !existing.getId().equals(e.getId())) {
                        throw new DuplicateResourceException("Employee ID already exists: " + dto.getEmployeeId());
                    }
                });

        employeeRepository.findByEmail(dto.getEmail())
                .ifPresent(e -> {
                    if (existing == null || !existing.getId().equals(e.getId())) {
                        throw new DuplicateResourceException("Email already in use: " + dto.getEmail());
                    }
                });
    }

    private void loadReferences(Employee employee, EmployeeRequestDto dto) {
        // Set Department
        if (dto.getDepartmentId() != null) {
            Department dept = departmentRepository.findById(dto.getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found: " + dto.getDepartmentId()));
            employee.setDepartment(dept);
        } else {
            employee.setDepartment(null);
        }

        // Set Designation
        if (dto.getDesignationId() != null) {
            Designation des = designationRepository.findById(dto.getDesignationId())
                    .orElseThrow(() -> new ResourceNotFoundException("Designation not found: " + dto.getDesignationId()));
            employee.setDesignation(des);
        } else {
            employee.setDesignation(null);
        }

        // Set Manager
        if (dto.getManagerId() != null) {
            Employee manager = employeeRepository.findById(dto.getManagerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Manager (Employee) not found: " + dto.getManagerId()));
            employee.setManager(manager);
        } else {
            employee.setManager(null);
        }

        // Set User
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found: " + dto.getUserId()));
            employee.setUser(user);
        } else {
            employee.setUser(null);
        }
    }
}
