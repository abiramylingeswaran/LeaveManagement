package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<employee, Long> {
    Optional<employee> findByEmployeeId(String employeeId);
    List<employee> findByActive(boolean active);
    List<employee> findByDepartmentId(Long departmentId);
}
