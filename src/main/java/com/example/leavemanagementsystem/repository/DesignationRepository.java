package com.example.leavemanagementsystem.repository;



import com.example.leavemanagementsystem.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {
    Optional<Designation> findByName(String name);
    List<Designation> findByActive(boolean active);
    List<Designation> findByNameContainingIgnoreCase(String nameKeyword);
}
