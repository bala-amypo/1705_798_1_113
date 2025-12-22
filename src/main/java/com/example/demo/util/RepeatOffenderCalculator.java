package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

import java.util.List;

public class RepeatOffenderCalculator {

    public RepeatOffenderRecord compute(StudentProfile student, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();

        // Link the student profile
        record.setStudentProfile(student);

        // Store total number of cases
        record.setTotalCases(cases.size());

        // Severity logic based on case count
        if (cases.size() == 1) {
            record.setFlagSeverity("LOW");
        } else if (cases.size() == 2) {
            record.setFlagSeverity("MEDIUM");
        } else if (cases.size() >= 4) {
            record.setFlagSeverity("HIGH");
        } else {
            record.setFlagSeverity("NONE");
        }

        return record;
    }
}
