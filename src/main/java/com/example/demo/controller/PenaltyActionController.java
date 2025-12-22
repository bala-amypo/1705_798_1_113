package com.example.demo.controller;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/penalty-actions")
public class PenaltyActionController {

    private final PenaltyActionService penaltyActionService;

    public PenaltyActionController(PenaltyActionService penaltyActionService) {
        this.penaltyActionService = penaltyActionService;
    }

    @PostMapping
    public ResponseEntity<PenaltyAction> createPenaltyAction(
            @RequestBody PenaltyAction penaltyAction) {

        PenaltyAction saved =
                penaltyActionService.createPenaltyAction(penaltyAction);

        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PenaltyAction> getPenaltyActionById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                penaltyActionService.getPenaltyActionById(id)
        );
    }

    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<PenaltyAction>> getPenaltyActionsByCaseId(
            @PathVariable Long caseId) {

        return ResponseEntity.ok(
                penaltyActionService.getPenaltyActionsByCaseId(caseId)
        );
    }

    @GetMapping
    public ResponseEntity<List<PenaltyAction>> getAllPenaltyActions() {
        return ResponseEntity.ok(
                penaltyActionService.getAllPenaltyActions()
        );
    }
}