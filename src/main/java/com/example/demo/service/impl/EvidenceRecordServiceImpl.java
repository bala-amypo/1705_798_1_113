package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.stereotype.Service;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository evidenceRepo;
    private final IntegrityCaseRepository caseRepo;

    public EvidenceRecordServiceImpl(EvidenceRecordRepository evidenceRepo, IntegrityCaseRepository caseRepo) {
        this.evidenceRepo = evidenceRepo;
        this.caseRepo = caseRepo;
    }

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord evidenceRecord) {
        if (evidenceRecord.getIntegrityCase() == null || evidenceRecord.getIntegrityCase().getId() == null) {
            throw new IllegalArgumentException("IntegrityCase required");
        }
        IntegrityCase ic = caseRepo.findById(evidenceRecord.getIntegrityCase().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Integrity case not found"));
        evidenceRecord.setIntegrityCase(ic);
        return evidenceRepo.save(evidenceRecord);
    }
}
