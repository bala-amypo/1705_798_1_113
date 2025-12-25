package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evidence")
@RequiredArgsConstructor
public class EvidenceRecordController {
    
    private final EvidenceRecordService evidenceRecordService;
    
    @PostMapping
    public ResponseEntity<EvidenceRecord> submitEvidence(@RequestBody EvidenceRecord evidenceRecord) {
        EvidenceRecord created = evidenceRecordService.submitEvidence(evidenceRecord);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}