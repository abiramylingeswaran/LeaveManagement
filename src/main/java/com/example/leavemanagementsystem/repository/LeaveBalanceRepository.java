package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {
    Optional<LeaveBalance> findByEmployeeIdAndLeaveTypeIdAndYear(Long employeeId, Long leaveTypeId, int year);
    List<LeaveBalance> findByEmployeeId(Long employeeId);
    List<LeaveBalance> findByYear(int year);
}
