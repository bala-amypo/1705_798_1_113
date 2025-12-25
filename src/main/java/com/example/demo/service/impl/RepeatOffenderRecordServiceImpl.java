package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final RepeatOffenderRecordRepository recordRepo;
    private final StudentProfileRepository studentRepo;

    public RepeatOffenderRecordServiceImpl(
            RepeatOffenderRecordRepository recordRepo,
            StudentProfileRepository studentRepo) {

        this.recordRepo = recordRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public RepeatOffenderRecord getRecordById(Long id) {
        return recordRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + id));
    }

    @Override
    public List<RepeatOffenderRecord> getAllRecords() {
        return recordRepo.findAll();
    }

    @Override
    public List<RepeatOffenderRecord> getRecordsByStudentId(Long studentId) {
        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
        return recordRepo.findByStudentProfile(student);
    }

    @Override
    public RepeatOffenderRecord saveRecord(RepeatOffenderRecord record) {
        return recordRepo.save(record);
    }

    @Override
    public void deleteRecord(Long id) {
        RepeatOffenderRecord record = getRecordById(id);
        recordRepo.delete(record);
    }
}
