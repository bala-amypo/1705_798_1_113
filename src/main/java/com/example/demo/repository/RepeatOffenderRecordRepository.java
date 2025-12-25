package com.example.demo.repository;

import com.example.demo.entity.RepeatOffenderRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepeatOffenderRecordRepository
        extends JpaRepository<RepeatOffenderRecord, Long> {

    Optional<RepeatOffenderRecord> findByStudentProfileId(Long studentId);
}
