package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.LeaveApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveApprovalRepository extends JpaRepository<LeaveApproval, Long> {
    List<LeaveApproval> findByLeaveRequestId(Long leaveRequestId);
    List<LeaveApproval> findByApproverId(Long approverId);
}
