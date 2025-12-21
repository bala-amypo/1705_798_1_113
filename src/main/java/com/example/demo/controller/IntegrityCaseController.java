package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class IntegrityCaseController {

    private final IntegrityCaseService caseService;

    public IntegrityCaseController(IntegrityCaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping
    public ApiResponse create(@RequestBody IntegrityCase integrityCase) {
        IntegrityCase saved = caseService.createCase(integrityCase);
        return new ApiResponse(true, "Case created", saved);
    }

    @PutMapping("/{id}/status")
    public ApiResponse updateStatus(@PathVariable Long id, @RequestParam String status) {
        IntegrityCase updated = caseService.updateCaseStatus(id, status);
        return new ApiResponse(true, "Status updated", updated);
    }

    @GetMapping("/student/{studentId}")
    public List<IntegrityCase> getByStudent(@PathVariable Long studentId) {
        return caseService.getCasesByStudent(studentId);
    }

    @GetMapping("/{id}")
    public IntegrityCase getById(@PathVariable Long id) {
        return caseService.getCaseById(id).orElse(null);
    }
}
