package com.example.demo.repository;

import com.example.demo.entity.IntegrityCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    List<IntegrityCase> findByStudentProfile_Id(Long studentId);

    // Simulated HQL methods (Mockito-backed in tests)
    List<IntegrityCase> findByStudentIdentifier(String studentIdentifier);

    List<IntegrityCase> findRecentCasesByStatus(String status, LocalDate sinceDate);

    List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);

    List<IntegrityCase> findByStatus(String status);

    List<IntegrityCase> findByStudentProfile(com.example.demo.entity.StudentProfile studentProfile);
}
