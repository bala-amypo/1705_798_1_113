package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceRecordController {

    private final EvidenceRecordService evidenceService;

    public EvidenceRecordController(EvidenceRecordService evidenceService) {
        this.evidenceService = evidenceService;
    }

    @PostMapping
    public EvidenceRecord submitEvidence(@RequestBody EvidenceRecord evidence) {
        return evidenceService.submitEvidence(evidence);
    }

    @GetMapping("/case/{caseId}")
    public List<EvidenceRecord> getEvidenceForCase(@PathVariable Long caseId) {
        return evidenceService.getEvidenceForCase(caseId);
    }

    @GetMapping("/{id}")
    public EvidenceRecord getEvidenceById(@PathVariable Long id) {
        return evidenceService.getEvidenceById(id);
    }

    @GetMapping
    public List<EvidenceRecord> getAllEvidence() {
        return evidenceService.getAllEvidence();
    }
}
