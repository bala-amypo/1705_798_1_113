package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService repeatOffenderRecordService;
    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;
    private final StudentProfileRepository studentProfileRepository;

    public RepeatOffenderRecordController(RepeatOffenderRecordService repeatOffenderRecordService,
                                          RepeatOffenderRecordRepository repeatOffenderRecordRepository,
                                          StudentProfileRepository studentProfileRepository) {
        this.repeatOffenderRecordService = repeatOffenderRecordService;
        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
        this.studentProfileRepository = studentProfileRepository;
    }

    // POST /api/repeat-offenders/refresh/{studentId} – Recalculate repeat-offender status
    @PostMapping("/refresh/{studentId}")
    public RepeatOffenderRecord refresh(@PathVariable Long studentId) {
        StudentProfile student = studentProfileRepository.findById(studentId).orElse(null);
        if (student == null) {
            return null;
        }
        return repeatOffenderRecordService.createRepeatOffenderRecord(student);
    }

    // GET /api/repeat-offenders/student/{studentId} – Get record for student
    @GetMapping("/student/{studentId}")
    public RepeatOffenderRecord getForStudent(@PathVariable Long studentId) {
        StudentProfile student = studentProfileRepository.findById(studentId).orElse(null);
        if (student == null) {
            return null;
        }
        return repeatOffenderRecordRepository.findByStudentProfile(student).orElse(null);
    }

    // GET /api/repeat-offenders/ – List all repeat offenders
    @GetMapping("/")
    public List<RepeatOffenderRecord> getAll() {
        return repeatOffenderRecordRepository.findAll();
    }
}
