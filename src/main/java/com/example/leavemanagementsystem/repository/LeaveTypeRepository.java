package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
    Optional<LeaveType> findByName(String name);
    List<LeaveType> findByActive(boolean active);
}
