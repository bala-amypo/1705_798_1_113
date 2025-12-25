package com.example.demo.repository;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {
    List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);
    List<IntegrityCase> findByStudentProfile_Id(Long studentProfileId);
    
    @Query("SELECT ic FROM IntegrityCase ic WHERE ic.studentProfile.studentId = :studentId")
    List<IntegrityCase> findByStudentIdentifier(@Param("studentId") String studentId);
    
    @Query("SELECT ic FROM IntegrityCase ic WHERE ic.status = :status AND ic.incidentDate >= :fromDate")
    List<IntegrityCase> findRecentCasesByStatus(@Param("status") String status, @Param("fromDate") LocalDate fromDate);
    
    @Query("SELECT ic FROM IntegrityCase ic WHERE ic.incidentDate BETWEEN :fromDate AND :toDate")
    List<IntegrityCase> findByIncidentDateBetween(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);
    
    List<IntegrityCase> findByStatus(String status);
}
