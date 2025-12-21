package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evidence")
public class EvidenceRecordController {

    private final EvidenceRecordService evidenceService;

    public EvidenceRecordController(EvidenceRecordService evidenceService) {
        this.evidenceService = evidenceService;
    }

    @PostMapping
    public ApiResponse submit(@RequestBody EvidenceRecord evidenceRecord) {
        EvidenceRecord saved = evidenceService.submitEvidence(evidenceRecord);
        return new ApiResponse(true, "Evidence submitted", saved);
    }
}
