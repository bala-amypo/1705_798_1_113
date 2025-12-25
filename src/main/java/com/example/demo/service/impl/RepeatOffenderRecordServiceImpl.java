package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final StudentProfileRepository studentProfileRepository;
    private final IntegrityCaseRepository integrityCaseRepository;
    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    private final RepeatOffenderCalculator calculator;

    // >>> ADD THIS CONSTRUCTOR (used in tests)
    public RepeatOffenderRecordServiceImpl(StudentProfileRepository studentProfileRepository,
                                           IntegrityCaseRepository integrityCaseRepository,
                                           RepeatOffenderRecordRepository repeatOffenderRecordRepository,
                                           RepeatOffenderCalculator calculator) {
        this.studentProfileRepository = studentProfileRepository;
        this.integrityCaseRepository = integrityCaseRepository;
        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
        this.calculator = calculator;
    }

    @Override
    public RepeatOffenderRecord createRepeatOffenderRecord(StudentProfile studentProfile) {
        RepeatOffenderRecord record = calculator.computeRepeatOffenderRecord(
                studentProfile, integrityCaseRepository.findByStudentProfile(studentProfile));
        record.setStudentProfile(studentProfile);
        return repeatOffenderRecordRepository.save(record);
    }
}
