package com.example.demo.repository;

import com.example.demo.entity.StudentProfile;  // This import must exist
import com.example.demo.entity.IntegrityCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {
    List<IntegrityCase> findByStudentProfile_Id(Long studentId);
    List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);  // Line 14
    List<IntegrityCase> findByStatus(String status);
    
    @Query("SELECT ic FROM IntegrityCase ic WHERE ic.studentProfile.studentId = :studentId")
    List<IntegrityCase> findByStudentIdentifier(@Param("studentId") String studentId);
    
    @Query("SELECT ic FROM IntegrityCase ic WHERE ic.status = :status AND ic.incidentDate >= :sinceDate")
    List<IntegrityCase> findRecentCasesByStatus(@Param("status") String status, 
                                                @Param("sinceDate") LocalDate sinceDate);
    
    @Query("SELECT ic FROM IntegrityCase ic WHERE ic.incidentDate BETWEEN :startDate AND :endDate")
    List<IntegrityCase> findByIncidentDateBetween(@Param("startDate") LocalDate startDate, 
                                                  @Param("endDate") LocalDate endDate);
}