package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.leavetype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveTypeRepository extends JpaRepository<leavetype, Long> {
    Optional<leavetype> findByName(String name);
    List<leavetype> findByActive(boolean active);
}
