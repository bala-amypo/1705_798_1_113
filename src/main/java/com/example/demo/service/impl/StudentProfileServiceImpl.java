package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.StudentProfileService;
import com.example.demo.util.RepeatOffenderCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentProfileServiceImpl implements StudentProfileService {
    
    private final StudentProfileRepository studentProfileRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    private final RepeatOffenderCalculator calculator;
    
    @Override
    @Transactional
    public StudentProfile createStudent(StudentProfile studentProfile) {
        studentProfile.setRepeatOffender(false);
        return studentProfileRepository.save(studentProfile);
    }
    
    @Override
    public StudentProfile getStudentById(Long id) {
        return studentProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }
    
    @Override
    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }
    
    @Override
    @Transactional
    public StudentProfile updateRepeatOffenderStatus(Long studentId) {
        StudentProfile student = getStudentById(studentId);
        List<IntegrityCase> cases = integrityCaseRepository.findByStudentProfile(student);
        
        RepeatOffenderRecord record = calculator.computeRepeatOffenderRecord(student, cases);
        
        if (record.getTotalCases() >= 2) {
            student.setRepeatOffender(true);
        } else {
            student.setRepeatOffender(false);
        }
        
        repeatOffenderRecordRepository.save(record);
        return studentProfileRepository.save(student);
    }
    
    @Override
    public StudentProfile getStudentByStudentId(String studentId) {
        return studentProfileRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + studentId));
    }
}