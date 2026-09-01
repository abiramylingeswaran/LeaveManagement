package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.LevaeRequest;
import com.example.leavemanagementsystem.enums.LeaveRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LevaeRequest, Long> {
    List<LevaeRequest> findByEmployeeIdAndStatus(Long employeeId, LeaveRequestStatus status);
    List<LevaeRequest> findByStatus(LeaveRequestStatus status);
    List<LevaeRequest> findByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
    List<LevaeRequest> findByEmployeeId(Long employeeId);
}
