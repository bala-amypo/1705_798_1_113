package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {
    
    @Autowired
    private PenaltyActionRepository penaltyActionRepository;
    
    @Autowired
    private IntegrityCaseRepository integrityCaseRepository;

    @Override
    public PenaltyAction addPenalty(PenaltyAction penalty) {
        IntegrityCase caseEntity = integrityCaseRepository.findById(penalty.getIntegrityCase().getId())
                .orElseThrow(() -> new IllegalArgumentException("Case not found"));
        if ("OPEN".equals(caseEntity.getStatus())) {
            caseEntity.setStatus("UNDER_REVIEW");
            integrityCaseRepository.save(caseEntity);
        }
        return penaltyActionRepository.save(penalty);
    }
}
