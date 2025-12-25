package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EvidenceRecordServiceImpl implements EvidenceRecordService {
    
    private final EvidenceRecordRepository evidenceRecordRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    
    @Override
    @Transactional
    public EvidenceRecord submitEvidence(EvidenceRecord evidenceRecord) {
        if (evidenceRecord.getIntegrityCase() == null || evidenceRecord.getIntegrityCase().getId() == null) {
            throw new IllegalArgumentException("Integrity case must be specified");
        }
        
        IntegrityCase integrityCase = integrityCaseRepository.findById(
                evidenceRecord.getIntegrityCase().getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Case not found with id: " + evidenceRecord.getIntegrityCase().getId()));
        
        evidenceRecord.setIntegrityCase(integrityCase);
        return evidenceRecordRepository.save(evidenceRecord);
    }
}