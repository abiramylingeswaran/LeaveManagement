package com.example.leavemanagementsystem.repository;

import com.example.leavemanagementsystem.entity.holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HolidayRepository extends JpaRepository<holiday, Long> {
    Optional<holiday> findByDate(LocalDate date);
    List<holiday> findByActive(boolean active);
}
