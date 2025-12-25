package com.example.demo.util;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.IntegrityCase;

import java.util.List;

public class RepeatOffenderCalculator {

    // Existing method
    public static String calculateSeverity(RepeatOffenderRecord record) {
        int count = record.getOffenceCount();

        if (count <= 1) return "LOW";
        if (count == 2) return "MEDIUM";
        return "HIGH";
    }

    // NEW method required by StudentProfileServiceImpl
    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile student, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setTotalCases(cases.size());
        record.setOffenceCount(cases.size()); // or compute based on your rules
        record.setSeverity(calculateSeverity(record));
        return record;
    }
}
