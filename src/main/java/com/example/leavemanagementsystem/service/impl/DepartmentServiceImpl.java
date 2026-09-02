package com.example.leavemanagementsystem.service.impl;

import com.example.leavemanagementsystem.entity.Department;
import com.example.leavemanagementsystem.repository.DepartmentRepository;
import com.example.leavemanagementsystem.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department dept) {
        return departmentRepository.save(dept);
    }

    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Optional<Department> getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public List<Department> getAllActiveDepartments() {
        return departmentRepository.findByActive(true);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}