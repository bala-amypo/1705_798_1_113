package com.example.demo.repository;

import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    Optional<StudentProfile> findByStudentId(String studentId);
    Optional<StudentProfile> findByEmail(String email);
    
    @Query("SELECT s FROM StudentProfile s WHERE s.repeatOffender = true")
    List<StudentProfile> findRepeatOffenders();
    
    @Query("SELECT s FROM StudentProfile s WHERE s.program = :program")
    List<StudentProfile> findByProgram(@Param("program") String program);
} 