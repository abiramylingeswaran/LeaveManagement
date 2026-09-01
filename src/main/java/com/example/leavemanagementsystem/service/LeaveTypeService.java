package com.example.leavemanagementsystem.service;

import com.example.leavemanagementsystem.entity.leavetype;
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

    public leavetype saveLeaveType(leavetype leaveType) {
        return leaveTypeRepository.save(leaveType);
    }

    public Optional<leavetype> getLeaveTypeById(Long id) {
        return leaveTypeRepository.findById(id);
    }

    public Optional<leavetype> getLeaveTypeByName(String name) {
        return leaveTypeRepository.findByName(name);
    }

    public List<leavetype> getAllActiveLeaveTypes() {
        return leaveTypeRepository.findByActive(true);
    }

    public List<leavetype> getAllLeaveTypes() {
        return leaveTypeRepository.findAll();
    }

    public void deleteLeaveType(Long id) {
        leaveTypeRepository.deleteById(id);
    }
}
