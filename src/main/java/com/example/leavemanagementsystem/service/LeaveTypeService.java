package com.example.leavemanagementsystem.service;

import com.example.leavemanagementsystem.entity.LeaveType;
import com.example.leavemanagementsystem.repository.LeaveTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveTypeService {

    private final LeaveTypeRepository leaveTypeRepository;

    public LeaveTypeService(LeaveTypeRepository leaveTypeRepository) {
        this.leaveTypeRepository = leaveTypeRepository;
    }

    public LeaveType saveLeaveType(LeaveType leaveType) {
        return leaveTypeRepository.save(leaveType);
    }

    public Optional<LeaveType> getLeaveTypeById(Long id) {
        return leaveTypeRepository.findById(id);
    }

    public Optional<LeaveType> getLeaveTypeByName(String name) {
        return leaveTypeRepository.findByName(name);
    }

    public List<LeaveType> getAllActiveLeaveTypes() {
        return leaveTypeRepository.findByActive(true);
    }

    public List<LeaveType> getAllLeaveTypes() {
        return leaveTypeRepository.findAll();
    }

    public void deleteLeaveType(Long id) {
        leaveTypeRepository.deleteById(id);
    }
}
