package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
import java.time.LocalDate;
import java.util.List;

public interface IntegrityCaseRepository
        extends JpaRepository<IntegrityCase, Long> {

    List<IntegrityCase> findByStudentProfile(StudentProfile s);
    List<IntegrityCase> findByStudentIdentifier(String id);
    List<IntegrityCase> findRecentCasesByStatus(String status, LocalDate date);
    List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);
}
