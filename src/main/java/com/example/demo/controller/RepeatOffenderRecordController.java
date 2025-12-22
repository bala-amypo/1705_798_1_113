package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService repeatService;

    public RepeatOffenderRecordController(RepeatOffenderRecordService repeatService) {
        this.repeatService = repeatService;
    }

    @PostMapping("/refresh/{studentId}")
    public RepeatOffenderRecord recalculateRepeatOffender(@PathVariable Long studentId) {
        return repeatService.recalculateRepeatOffender(studentId);
    }

    @GetMapping("/student/{studentId}")
    public RepeatOffenderRecord getRecordForStudent(@PathVariable Long studentId) {
        return repeatService.getRecordForStudent(studentId);
    }

    @GetMapping
    public List<RepeatOffenderRecord> getAllRepeatOffenders() {
        return repeatService.getAllRepeatOffenders();
    }
}
