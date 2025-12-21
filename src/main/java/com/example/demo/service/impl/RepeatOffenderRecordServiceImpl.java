package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository repeatRepo;

    public RepeatOffenderRecordServiceImpl(StudentProfileRepository studentRepo,
                                           IntegrityCaseRepository caseRepo,
                                           RepeatOffenderRecordRepository repeatRepo) {
        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.repeatRepo = repeatRepo;
    }

    @Override
    public RepeatOffenderRecord recalculate(StudentProfile studentProfile) {
        StudentProfile sp = studentRepo.findById(studentProfile.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid StudentProfile"));
        List<IntegrityCase> cases = caseRepo.findByStudentProfile_Id(sp.getId());
        int total = cases.size();
        String severity = (total <= 1) ? "LOW" : (total == 2 ? "MEDIUM" : (total >= 4 ? "HIGH" : "MEDIUM"));
        LocalDate firstDate = cases.stream()
                .map(IntegrityCase::getIncidentDate)
                .filter(d -> d != null)
                .min(Comparator.naturalOrder()).orElse(null);

        RepeatOffenderRecord record = repeatRepo.findByStudentProfile(sp).orElseGet(RepeatOffenderRecord::new);
        record.setStudentProfile(sp);
        record.setTotalCases(total);
        record.setFlagSeverity(severity);
        record.setFirstIncidentDate(firstDate);
        repeatRepo.save(record);

        sp.setRepeatOffender(total >= 2);
        studentRepo.save(sp);
        return record;
    }
}
