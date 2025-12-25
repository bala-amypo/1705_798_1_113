package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/repeat-offender-records")
@RequiredArgsConstructor
public class RepeatOffenderRecordController {
    
    private final RepeatOffenderRecordService repeatOffenderRecordService;
    
    @PutMapping("/student/{studentId}")
    public ResponseEntity<RepeatOffenderRecord> updateOrCreateRecord(@PathVariable Long studentId) {
        RepeatOffenderRecord record = repeatOffenderRecordService.updateOrCreateRecord(studentId);
        return ResponseEntity.ok(record);
    }
    
    @GetMapping
    public ResponseEntity<List<RepeatOffenderRecord>> getAllRecords() {
        List<RepeatOffenderRecord> records = repeatOffenderRecordService.getAllRecords();
        return ResponseEntity.ok(records);
    }
}