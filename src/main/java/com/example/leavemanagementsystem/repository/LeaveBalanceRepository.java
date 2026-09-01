package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.leavebalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<leavebalance, Long> {
    Optional<leavebalance> findByEmployeeIdAndLeaveTypeIdAndYear(Long employeeId, Long leaveTypeId, int year);
    List<leavebalance> findByEmployeeId(Long employeeId);
    List<leavebalance> findByYear(int year);
}
