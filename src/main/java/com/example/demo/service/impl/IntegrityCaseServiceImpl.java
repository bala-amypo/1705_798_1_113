package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {
    
    @Autowired
    private IntegrityCaseRepository integrityCaseRepository;
    
    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        if (integrityCase.getStudentProfile() == null || 
            integrityCase.getStudentProfile().getId() == null) {
            throw new IllegalArgumentException("Student profile is required");
        }
        studentProfileRepository.findById(integrityCase.getStudentProfile().getId());
        if (integrityCase.getStatus() == null) {
            integrityCase.setStatus("OPEN");
        }
        return integrityCaseRepository.save(integrityCase);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long caseId, String status) {
        IntegrityCase caseEntity = integrityCaseRepository.findById(caseId)
                .orElseThrow(() -> new IllegalArgumentException("Case not found"));
        caseEntity.setStatus(status);
        return integrityCaseRepository.save(caseEntity);
    }

    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        return integrityCaseRepository.findByStudentProfile_Id(studentId);
    }

    @Override
    public Optional<IntegrityCase> getCaseById(Long caseId) {
        return integrityCaseRepository.findById(caseId);
    }
}
