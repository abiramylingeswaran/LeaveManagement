package com.example.leavemanagementsystem.service;

import com.example.leavemanagementsystem.entity.LevaeRequest;
import com.example.leavemanagementsystem.enums.LeaveRequestStatus;
import com.example.leavemanagementsystem.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    public LevaeRequest submitLeaveRequest(LevaeRequest request) {
        request.setStatus(LeaveRequestStatus.PENDING);
        return leaveRequestRepository.save(request);
    }

    public Optional<LevaeRequest> getLeaveRequestById(Long id) {
        return leaveRequestRepository.findById(id);
    }

    public List<LevaeRequest> getPendingRequestsForEmployee(Long employeeId) {
        return leaveRequestRepository.findByEmployeeIdAndStatus(employeeId, LeaveRequestStatus.PENDING);
    }

    public List<LevaeRequest> getAllPendingRequests() {
        return leaveRequestRepository.findByStatus(LeaveRequestStatus.PENDING);
    }

    public List<LevaeRequest> getEmployeeLeaveHistory(Long employeeId) {
        return leaveRequestRepository.findByEmployeeId(employeeId);
    }

    public LevaeRequest updateRequestStatus(Long requestId, LeaveRequestStatus status) {
        Optional<LevaeRequest> optional = leaveRequestRepository.findById(requestId);
        if (optional.isPresent()) {
            LevaeRequest request = optional.get();
            request.setStatus(status);
            return leaveRequestRepository.save(request);
        }
        return null;
    }

    public List<LevaeRequest> getConflictingLeaves(LocalDate startDate, LocalDate endDate) {
        return leaveRequestRepository.findByStartDateAndEndDate(startDate, endDate);
    }

    public void deleteLeaveRequest(Long id) {
        leaveRequestRepository.deleteById(id);
    }
}
