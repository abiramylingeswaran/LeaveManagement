package com.example.leavemanagementsystem.service;

import com.example.leavemanagementsystem.entity.LeaveBalance;
import com.example.leavemanagementsystem.repository.LeaveBalanceRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveBalanceService {

    private final LeaveBalanceRepository leaveBalanceRepository;

    public LeaveBalanceService(LeaveBalanceRepository leaveBalanceRepository) {
        this.leaveBalanceRepository = leaveBalanceRepository;
    }

    public LeaveBalance saveLeaveBalance(LeaveBalance balance) {
        return leaveBalanceRepository.save(balance);
    }

    public Optional<LeaveBalance> getLeaveBalance(Long employeeId, Long leaveTypeId) {
        int currentYear = LocalDate.now().getYear();
        return leaveBalanceRepository.findByEmployeeIdAndLeaveTypeIdAndYear(employeeId, leaveTypeId, currentYear);
    }

    public List<LeaveBalance> getEmployeeBalances(Long employeeId) {
        return leaveBalanceRepository.findByEmployeeId(employeeId);
    }

    public void updateLeaveBalance(Long employeeId, Long leaveTypeId, BigDecimal daysUsed) {
        int currentYear = LocalDate.now().getYear();
        Optional<LeaveBalance> optionalBalance = leaveBalanceRepository.findByEmployeeIdAndLeaveTypeIdAndYear(employeeId, leaveTypeId, currentYear);
        
        if (optionalBalance.isPresent()) {
            LeaveBalance balance = optionalBalance.get();
            BigDecimal newUsed = balance.getUsed().add(daysUsed);
            BigDecimal newAvailable = balance.getEntitled()
                .add(balance.getCarryForward())
                .add(balance.getAdjustments())
                .subtract(newUsed)
                .subtract(balance.getPending());
            
            balance.setUsed(newUsed);
            balance.setAvailable(newAvailable);
            leaveBalanceRepository.save(balance);
        }
    }

    public List<LeaveBalance> getBalancesByYear(int year) {
        return leaveBalanceRepository.findByYear(year);
    }

    public void deleteLeaveBalance(Long id) {
        leaveBalanceRepository.deleteById(id);
    }
}
