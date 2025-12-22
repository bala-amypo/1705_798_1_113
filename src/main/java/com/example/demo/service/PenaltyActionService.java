package com.example.demo.service;

import com.example.demo.entity.PenaltyAction;
import java.util.List;

public interface PenaltyActionService {
    PenaltyAction addPenalty(PenaltyAction penalty);
    List<PenaltyAction> getPenaltiesForCase(Long caseId);
    PenaltyAction getPenaltyById(Long id);
    List<PenaltyAction> getAllPenalties();
}
