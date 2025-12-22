package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final RepeatOffenderRecordRepository repo;

    public RepeatOffenderRecordServiceImpl(RepeatOffenderRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public RepeatOffenderRecord recalculateRepeatOffender(Long studentId) {
        RepeatOffenderRecord record = repo.findByStudentId(studentId).orElse(new RepeatOffenderRecord(studentId));
        record.setRepeatCount(record.getRepeatCount() + 1);
        return repo.save(record);
    }

    @Override
    public RepeatOffenderRecord getRecordForStudent(Long studentId) {
        return repo.findByStudentId(studentId).orElse(null);
    }

    @Override
    public List<RepeatOffenderRecord> getAllRepeatOffenders() {
        return repo.findAll();
    }
}
