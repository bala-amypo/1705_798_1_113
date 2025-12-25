package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {
    
    private final StudentProfileRepository studentProfileRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    private final RepeatOffenderCalculator calculator;
    
    @Override
    @Transactional
    public RepeatOffenderRecord updateOrCreateRecord(Long studentId) {
        StudentProfile student = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
        
        List<IntegrityCase> cases = integrityCaseRepository.findByStudentProfile(student);
        RepeatOffenderRecord record = calculator.computeRepeatOffenderRecord(student, cases);
        
        return repeatOffenderRecordRepository.save(record);
    }
    
    @Override
    public List<RepeatOffenderRecord> getAllRecords() {
        return repeatOffenderRecordRepository.findAll();
    }
}