package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cases")
@RequiredArgsConstructor
public class IntegrityCaseController {
    
    private final IntegrityCaseService integrityCaseService;
    
    @PostMapping
    public ResponseEntity<IntegrityCase> createCase(@RequestBody IntegrityCase integrityCase) {
        IntegrityCase created = integrityCaseService.createCase(integrityCase);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<IntegrityCase> updateCaseStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        IntegrityCase updated = integrityCaseService.updateCaseStatus(id, status);
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<IntegrityCase>> getCasesByStudent(@PathVariable Long studentId) {
        List<IntegrityCase> cases = integrityCaseService.getCasesByStudent(studentId);
        return ResponseEntity.ok(cases);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<IntegrityCase> getCaseById(@PathVariable Long id) {
        return integrityCaseService.getCaseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<IntegrityCase>> getCasesByStatus(@PathVariable String status) {
        List<IntegrityCase> cases = integrityCaseService.getCasesByStatus(status);
        return ResponseEntity.ok(cases);
    }
}