package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.leaveApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveApprovalRepository extends JpaRepository<leaveApproval, Long> {
    List<leaveApproval> findByLeaveRequestId(Long leaveRequestId);
    List<leaveApproval> findByApproverId(Long approverId);
}
