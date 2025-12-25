package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {
    
    @Autowired
    private StudentProfileRepository studentProfileRepository;
    
    @Autowired
    private IntegrityCaseRepository integrityCaseRepository;
    
    @Autowired
    private RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    
    @Autowired
    private RepeatOffenderCalculator calculator;

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        student.setRepeatOffender(false);
        return studentProfileRepository.save(student);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return studentProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }

    @Override
    public StudentProfile updateRepeatOffenderStatus(Long studentId) {
        StudentProfile student = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        
        List<IntegrityCase> cases = integrityCaseRepository.findByStudentProfile(student);
        RepeatOffenderRecord existingRecord = repeatOffenderRecordRepository
                .findByStudentProfile(student).orElse(null);
        
        RepeatOffenderRecord record = calculator.computeRepeatOffenderRecord(student, cases);
        
        if (existingRecord == null) {
            record.setStudentProfile(student);
            repeatOffenderRecordRepository.save(record);
        }
        
        student.setRepeatOffender(record.getTotalCases() >= 2);
        return studentProfileRepository.save(student);
    }
}
