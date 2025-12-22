package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.service.RepeatOffenderRecordService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final RepeatOffenderRecordRepository repository;

    public RepeatOffenderRecordServiceImpl(
            RepeatOffenderRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public RepeatOffenderRecord createRecord(RepeatOffenderRecord record) {
        return repository.save(record);
    }

    @Override
    public RepeatOffenderRecord getRecordById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<RepeatOffenderRecord> getAllRecords() {
        return repository.findAll();
    }
}
