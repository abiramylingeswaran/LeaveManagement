package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.LeavePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeavePolicyRepository extends JpaRepository<LeavePolicy, Long> {
    Optional<LeavePolicy> findByName(String name);
    List<LeavePolicy> findByActive(boolean active);
    List<LeavePolicy> findByLeaveTypeId(Long leaveTypeId);
}
