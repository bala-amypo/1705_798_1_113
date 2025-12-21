package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repeat-offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService repeatService;

    public RepeatOffenderRecordController(RepeatOffenderRecordService repeatService) {
        this.repeatService = repeatService;
    }

    @PostMapping("/recalculate/{studentId}")
    public ApiResponse recalc(@PathVariable Long studentId) {
        StudentProfile sp = new StudentProfile();
        sp.setId(studentId);
        RepeatOffenderRecord record = repeatService.recalculate(sp);
        return new ApiResponse(true, "Repeat offender record recalculated", record);
    }
}
