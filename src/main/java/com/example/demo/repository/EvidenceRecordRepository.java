package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.EvidenceRecord;

import java.util.List;

public interface EvidenceRecordRepository
        extends JpaRepository<EvidenceRecord, Long> {

    List<EvidenceRecord> findByIntegrityCaseId(Long id);
}
