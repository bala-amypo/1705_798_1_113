package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository repeatRepo;

    public StudentProfileServiceImpl(StudentProfileRepository studentRepo,
                                     IntegrityCaseRepository caseRepo,
                                     RepeatOffenderRecordRepository repeatRepo) {
        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.repeatRepo = repeatRepo;
    }

    @Override
    public StudentProfile createStudent(StudentProfile studentProfile) {
        studentProfile.setRepeatOffender(false);
        // createdAt handled in @PrePersist
        return studentRepo.save(studentProfile);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found"));
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public StudentProfile updateRepeatOffenderStatus(Long studentId) {
        StudentProfile sp = getStudentById(studentId);
        List<IntegrityCase> cases = caseRepo.findByStudentProfile_Id(sp.getId());
        int total = cases.size();
        String severity = (total <= 1) ? "LOW" : (total == 2 ? "MEDIUM" : (total >= 4 ? "HIGH" : "MEDIUM"));
        LocalDate firstDate = cases.stream()
                .map(IntegrityCase::getIncidentDate)
                .filter(d -> d != null)
                .min(Comparator.naturalOrder())
                .orElse(null);

        RepeatOffenderRecord record = repeatRepo.findByStudentProfile(sp).orElseGet(RepeatOffenderRecord::new);
        record.setStudentProfile(sp);
        record.setTotalCases(total);
        record.setFlagSeverity(severity);
        record.setFirstIncidentDate(firstDate);
        repeatRepo.save(record);

        sp.setRepeatOffender(total >= 2); // threshold: 2 or more cases
        return studentRepo.save(sp);
    }
}
