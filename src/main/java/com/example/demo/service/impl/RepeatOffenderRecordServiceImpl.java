package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RepeatOffenderRecordServiceImpl
        implements RepeatOffenderRecordService {

    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final IntegrityCaseRepository integrityCaseRepository;

    public RepeatOffenderRecordServiceImpl(
            RepeatOffenderRecordRepository repeatOffenderRecordRepository,
            StudentProfileRepository studentProfileRepository,
            IntegrityCaseRepository integrityCaseRepository) {

        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.integrityCaseRepository = integrityCaseRepository;
    }

    @Override
    public RepeatOffenderRecord updateOrCreateRecord(Long studentId) {

        StudentProfile student = studentProfileRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found"));

        RepeatOffenderRecord record =
                repeatOffenderRecordRepository
                        .findByStudentProfileId(studentId)
                        .orElse(new RepeatOffenderRecord());

        record.setStudentProfile(student);

        int offences = integrityCaseRepository
                .findByStudentProfileId(studentId)
                .size();

        record.setOffenceCount(offences);
        record.setLastOffenceDate(LocalDate.now());
        record.setSeverityLevel(
                RepeatOffenderCalculator.calculateSeverity(record));

        return repeatOffenderRecordRepository.save(record);
    }

    @Override
    public List<RepeatOffenderRecord> getAllRecords() {
        return repeatOffenderRecordRepository.findAll();
    }
}
