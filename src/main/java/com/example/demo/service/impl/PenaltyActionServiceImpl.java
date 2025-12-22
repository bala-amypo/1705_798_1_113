package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository repo;

    public PenaltyActionServiceImpl(PenaltyActionRepository repo) {
        this.repo = repo;
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction penalty) {
        return repo.save(penalty);
    }

    @Override
    public List<PenaltyAction> getPenaltiesForCase(Long caseId) {
        return repo.findByCaseId(caseId);
    }

    @Override
    public PenaltyAction getPenaltyById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<PenaltyAction> getAllPenalties() {
        return repo.findAll();
    }
}
