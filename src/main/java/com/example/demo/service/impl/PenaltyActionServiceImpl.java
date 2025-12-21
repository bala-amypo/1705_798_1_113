package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.PenaltyActionService;
import org.springframework.stereotype.Service;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository penaltyRepo;
    private final IntegrityCaseRepository caseRepo;

    public PenaltyActionServiceImpl(PenaltyActionRepository penaltyRepo, IntegrityCaseRepository caseRepo) {
        this.penaltyRepo = penaltyRepo;
        this.caseRepo = caseRepo;
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction penaltyAction) {
        if (penaltyAction.getIntegrityCase() == null || penaltyAction.getIntegrityCase().getId() == null) {
            throw new IllegalArgumentException("IntegrityCase required");
        }
        IntegrityCase ic = caseRepo.findById(penaltyAction.getIntegrityCase().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Integrity case not found"));
        penaltyAction.setIntegrityCase(ic);
        // business rule: move case status from OPEN to UNDER_REVIEW
        if ("OPEN".equalsIgnoreCase(ic.getStatus())) {
            ic.setStatus("UNDER_REVIEW");
            caseRepo.save(ic);
        }
        return penaltyRepo.save(penaltyAction);
    }
}
