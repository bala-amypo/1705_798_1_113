package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService repeatOffenderRecordService;

    public RepeatOffenderRecordController(
            RepeatOffenderRecordService repeatOffenderRecordService) {
        this.repeatOffenderRecordService = repeatOffenderRecordService;
    }

    @PostMapping
    public ResponseEntity<RepeatOffenderRecord> createRecord(
            @RequestBody RepeatOffenderRecord record) {

        RepeatOffenderRecord saved =
                repeatOffenderRecordService.createRecord(record);

        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepeatOffenderRecord> getRecordById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                repeatOffenderRecordService.getRecordById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<RepeatOffenderRecord>> getAllRecords() {
        return ResponseEntity.ok(
                repeatOffenderRecordService.getAllRecords()
        );
    }
}