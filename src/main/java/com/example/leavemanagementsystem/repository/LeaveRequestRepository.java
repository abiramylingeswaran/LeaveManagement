package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.levaerequest;
import com.example.leavemanagementsystem.enums.LeaveRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<levaerequest, Long> {
    List<levaerequest> findByEmployeeIdAndStatus(Long employeeId, LeaveRequestStatus status);
    List<levaerequest> findByStatus(LeaveRequestStatus status);
    List<levaerequest> findByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
    List<levaerequest> findByEmployeeId(Long employeeId);
}
