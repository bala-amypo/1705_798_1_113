package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository repository;

    public PenaltyActionServiceImpl(PenaltyActionRepository repository) {
        this.repository = repository;
    }

    @Override
    public PenaltyAction createPenaltyAction(PenaltyAction penaltyAction) {
        return repository.save(penaltyAction);
    }

    @Override
    public PenaltyAction getPenaltyActionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Penalty not found with id: " + id)
                );
    }

    @Override
    public List<PenaltyAction> getAllPenaltyActions() {
        return repository.findAll();
    }

    @Override
    public List<PenaltyAction> getPenaltyActionsByCaseId(Long caseId) {
        return repository.findByIntegrityCaseId(caseId);
    }
}
