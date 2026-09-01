package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.leavePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeavePolicyRepository extends JpaRepository<leavePolicy, Long> {
    Optional<leavePolicy> findByName(String name);
    List<leavePolicy> findByActive(boolean active);
    List<leavePolicy> findByLeaveTypeId(Long leaveTypeId);
}
