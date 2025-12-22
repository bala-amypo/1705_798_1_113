package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidence-records")
public class EvidenceRecordController {

    private final EvidenceRecordService evidenceRecordService;

    public EvidenceRecordController(EvidenceRecordService evidenceRecordService) {
        this.evidenceRecordService = evidenceRecordService;
    }

    @PostMapping
    public ResponseEntity<EvidenceRecord> createEvidence(
            @RequestBody EvidenceRecord evidenceRecord) {

        EvidenceRecord saved =
                evidenceRecordService.createEvidenceRecord(evidenceRecord);

        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvidenceRecord> getEvidenceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                evidenceRecordService.getEvidenceRecordById(id)
        );
    }

    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<EvidenceRecord>> getEvidenceByCaseId(
            @PathVariable Long caseId) {

        return ResponseEntity.ok(
                evidenceRecordService.getEvidenceRecordsByCaseId(caseId)
        );
    }

    @GetMapping
    public ResponseEntity<List<EvidenceRecord>> getAllEvidence() {
        return ResponseEntity.ok(
                evidenceRecordService.getAllEvidenceRecords()
        );
    }
}