package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.PenaltyActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PenaltyActionServiceImpl implements PenaltyActionService {
    
    private final PenaltyActionRepository penaltyActionRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    
    @Override
    @Transactional
    public PenaltyAction addPenalty(PenaltyAction penaltyAction) {
        if (penaltyAction.getIntegrityCase() == null || penaltyAction.getIntegrityCase().getId() == null) {
            throw new IllegalArgumentException("Integrity case must be specified");
        }
        
        IntegrityCase integrityCase = integrityCaseRepository.findById(
                penaltyAction.getIntegrityCase().getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Case not found with id: " + penaltyAction.getIntegrityCase().getId()));
        
        // Update case status when penalty is added
        integrityCase.setStatus("UNDER_REVIEW");
        integrityCaseRepository.save(integrityCase);
        
        penaltyAction.setIntegrityCase(integrityCase);
        return penaltyActionRepository.save(penaltyAction);
    }
}