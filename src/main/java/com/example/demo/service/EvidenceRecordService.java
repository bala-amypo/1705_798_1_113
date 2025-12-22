package com.example.demo.service;

import com.example.demo.entity.EvidenceRecord;
import java.util.List;

public interface EvidenceRecordService {

    EvidenceRecord createEvidenceRecord(EvidenceRecord evidenceRecord);

    EvidenceRecord getEvidenceRecordById(Long id);

    List<EvidenceRecord> getAllEvidenceRecords();

    List<EvidenceRecord> getEvidenceRecordsByCaseId(Long caseId);
}
