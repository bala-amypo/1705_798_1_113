package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cases")
public class IntegrityCaseController {

    private final IntegrityCaseService integrityCaseService;

    public IntegrityCaseController(IntegrityCaseService integrityCaseService) {
        this.integrityCaseService = integrityCaseService;
    }

    // POST /api/cases/ – Create new integrity case
    @PostMapping("/")
    public IntegrityCase create(@RequestBody IntegrityCase integrityCase) {
        return integrityCaseService.createCase(integrityCase);
    }

    // PUT /api/cases/{id}/status – Update case status
    @PutMapping("/{id}/status")
    public IntegrityCase updateStatus(@PathVariable Long id,
                                      @RequestParam String status) {
        return integrityCaseService.updateCaseStatus(id, status);
    }

    // GET /api/cases/student/{studentId} – Get cases by student
    @GetMapping("/student/{studentId}")
    public List<IntegrityCase> getByStudent(@PathVariable Long studentId) {
        return integrityCaseService.getCasesByStudent(studentId);
    }

    // GET /api/cases/{id} – Get case by ID
    @GetMapping("/{id}")
    public Optional<IntegrityCase> getById(@PathVariable Long id) {
        return integrityCaseService.getCaseById(id);
    }

    // GET /api/cases/ – List all cases
    @GetMapping("/")
    public List<IntegrityCase> getAll() {
        // simple: aggregate from repository via service
        return integrityCaseService.getCasesByStudent(null); // adapt if you add getAllCases()
    }
}
