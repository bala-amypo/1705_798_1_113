package com.example.demo.repository;

import com.example.demo.entity.EvidenceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EvidenceRecordRepository extends JpaRepository<EvidenceRecord, Long> {
    List<EvidenceRecord> findByIntegrityCase_Id(Long caseId);
}