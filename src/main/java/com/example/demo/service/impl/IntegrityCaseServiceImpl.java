package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.IntegrityCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IntegrityCaseServiceImpl implements IntegrityCaseService {
    
    private final IntegrityCaseRepository integrityCaseRepository;
    private final StudentProfileRepository studentProfileRepository;
    
    @Override
    @Transactional
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        if (integrityCase.getStudentProfile() == null || integrityCase.getStudentProfile().getId() == null) {
            throw new IllegalArgumentException("Student profile must be specified");
        }
        
        StudentProfile student = studentProfileRepository.findById(
                integrityCase.getStudentProfile().getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student not found with id: " + integrityCase.getStudentProfile().getId()));
        
        integrityCase.setStudentProfile(student);
        return integrityCaseRepository.save(integrityCase);
    }
    
    @Override
    @Transactional
    public IntegrityCase updateCaseStatus(Long caseId, String status) {
        IntegrityCase integrityCase = integrityCaseRepository.findById(caseId)
                .orElseThrow(() -> new ResourceNotFoundException("Case not found with id: " + caseId));
        
        integrityCase.setStatus(status);
        return integrityCaseRepository.save(integrityCase);
    }
    
    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        return integrityCaseRepository.findByStudentProfile_Id(studentId);
    }
    
    @Override
    public Optional<IntegrityCase> getCaseById(Long id) {
        return integrityCaseRepository.findById(id);
    }
    
    @Override
    public List<IntegrityCase> getCasesByStatus(String status) {
        return integrityCaseRepository.findByStatus(status);
    }
}