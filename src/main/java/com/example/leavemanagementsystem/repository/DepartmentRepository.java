package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<department, Long> {
    Optional<department> findByName(String name);
    List<department> findByActive(boolean active);
}
