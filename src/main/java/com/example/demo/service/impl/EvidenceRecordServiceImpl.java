package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository repo;

    public EvidenceRecordServiceImpl(EvidenceRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord evidence) {
        return repo.save(evidence);
    }

    @Override
    public List<EvidenceRecord> getEvidenceForCase(Long caseId) {
        return repo.findByCaseId(caseId);
    }

    @Override
    public EvidenceRecord getEvidenceById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<EvidenceRecord> getAllEvidence() {
        return repo.findAll();
    }
}
