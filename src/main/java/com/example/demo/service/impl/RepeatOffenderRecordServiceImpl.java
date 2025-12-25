package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {
    
    @Autowired
    private StudentProfileRepository studentProfileRepository;
    
    @Autowired
    private IntegrityCaseRepository integrityCaseRepository;
    
    @Autowired
    private RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    
    @Autowired
    private RepeatOffenderCalculator calculator;

    @Override
    public RepeatOffenderRecord createRepeatOffenderRecord(StudentProfile studentProfile) {
        RepeatOffenderRecord record = calculator.computeRepeatOffenderRecord(
            studentProfile, integrityCaseRepository.findByStudentProfile(studentProfile));
        record.setStudentProfile(studentProfile);
        return repeatOffenderRecordRepository.save(record);
    }
}
