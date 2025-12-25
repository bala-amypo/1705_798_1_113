package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;
import org.springframework.stereotype.Service;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository penaltyActionRepository;
    private final IntegrityCaseRepository integrityCaseRepository;

    // >>> ADD THIS CONSTRUCTOR (used in tests)
    public PenaltyActionServiceImpl(PenaltyActionRepository penaltyActionRepository,
                                    IntegrityCaseRepository integrityCaseRepository) {
        this.penaltyActionRepository = penaltyActionRepository;
        this.integrityCaseRepository = integrityCaseRepository;
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction penalty) {
        IntegrityCase c = integrityCaseRepository.findById(penalty.getIntegrityCase().getId())
                .orElseThrow(() -> new IllegalArgumentException("Case not found"));
        if ("OPEN".equals(c.getStatus())) {
            c.setStatus("UNDER_REVIEW");
            integrityCaseRepository.save(c);
        }
        return penaltyActionRepository.save(penalty);
    }
}
