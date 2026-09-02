package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmployeeId(String employeeId);
    List<Employee> findByActive(boolean active);
    List<Employee> findByDepartmentId(Long departmentId);
    Optional<Employee>findByEmail(String email);
}
