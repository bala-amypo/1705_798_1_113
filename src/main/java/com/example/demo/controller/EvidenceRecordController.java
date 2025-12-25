package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceRecordController {

    private final EvidenceRecordService evidenceRecordService;
    private final EvidenceRecordRepository evidenceRecordRepository;

    public EvidenceRecordController(EvidenceRecordService evidenceRecordService,
                                    EvidenceRecordRepository evidenceRecordRepository) {
        this.evidenceRecordService = evidenceRecordService;
        this.evidenceRecordRepository = evidenceRecordRepository;
    }

    // POST /api/evidence/ – Submit new evidence
    @PostMapping("/")
    public EvidenceRecord submit(@RequestBody EvidenceRecord evidence) {
        return evidenceRecordService.submitEvidence(evidence);
    }

    // GET /api/evidence/case/{caseId} – Get evidence for case
    @GetMapping("/case/{caseId}")
    public List<EvidenceRecord> getByCase(@PathVariable Long caseId) {
        return evidenceRecordRepository.findAll().stream()
                .filter(e -> e.getIntegrityCase() != null &&
                             caseId.equals(e.getIntegrityCase().getId()))
                .toList();
    }

    // GET /api/evidence/{id} – Get evidence by ID
    @GetMapping("/{id}")
    public EvidenceRecord getById(@PathVariable Long id) {
        return evidenceRecordRepository.findById(id).orElse(null);
    }

    // GET /api/evidence/ – List all evidence
    @GetMapping("/")
    public List<EvidenceRecord> getAll() {
        return evidenceRecordRepository.findAll();
    }
}
