package com.example.demo.util;

public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile student, List<IntegrityCase> cases) {

        RepeatOffenderRecord r = new RepeatOffenderRecord();
        r.setStudentProfile(student);
        r.setTotalCases(cases.size());

        if (cases.size() >= 4) r.setFlagSeverity("HIGH");
        else if (cases.size() == 2) r.setFlagSeverity("MEDIUM");
        else r.setFlagSeverity("LOW");

        return r;
    }
}
