package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;

public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository evidenceRepo;
    private final IntegrityCaseRepository caseRepo;

    public EvidenceRecordServiceImpl(
            EvidenceRecordRepository evidenceRepo,
            IntegrityCaseRepository caseRepo) {

        this.evidenceRepo = evidenceRepo;
        this.caseRepo = caseRepo;
    }

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord evidence) {
        IntegrityCase c = caseRepo.findById(
                evidence.getIntegrityCase().getId())
                .orElseThrow(() -> new IllegalArgumentException("Case not found"));

        evidence.setIntegrityCase(c);
        return evidenceRepo.save(evidence);
    }
}
