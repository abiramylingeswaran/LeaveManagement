package com.example.leavemanagementsystem.service;

import com.example.leavemanagementsystem.entity.employee;
import com.example.leavemanagementsystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public employee saveEmployee(employee emp) {
        return employeeRepository.save(emp);
    }

    public Optional<employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Optional<employee> getEmployeeByEmployeeId(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    public List<employee> getAllActiveEmployees() {
        return employeeRepository.findByActive(true);
    }

    public List<employee> getEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
