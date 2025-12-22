package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository repo;

    public IntegrityCaseServiceImpl(IntegrityCaseRepository repo) {
        this.repo = repo;
    }

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        return repo.save(integrityCase);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long id, String status) {
        IntegrityCase integrityCase = repo.findById(id).orElse(null);
        if (integrityCase != null) {
            integrityCase.setStatus(status);
            return repo.save(integrityCase);
        }
        return null;
    }

    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        return repo.findByStudentId(studentId);
    }

    @Override
    public IntegrityCase getCaseById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<IntegrityCase> getAllCases() {
        return repo.findAll();
    }
}
