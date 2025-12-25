package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

import java.util.Comparator;
import java.util.List;

public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile student,
            List<IntegrityCase> cases) {

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);

        int total = cases == null ? 0 : cases.size();
        record.setTotalCases(total);

        if (total <= 1) {
            record.setFlagSeverity("LOW");
        } else if (total == 2) {
            record.setFlagSeverity("MEDIUM");
        } else {
            record.setFlagSeverity("HIGH");
        }

        if (cases != null && !cases.isEmpty()) {
            record.setFirstIncidentDate(
                    cases.stream()
                         .map(IntegrityCase::getIncidentDate)
                         .min(Comparator.naturalOrder())
                         .orElse(null)
            );
        }

        return record;
    }
}
