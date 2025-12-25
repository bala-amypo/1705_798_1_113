package com.example.demo.util;

import java.util.List;
import com.example.demo.entity.*;

public class RepeatOffenderCalculator {

    public static RepeatOffenderRecord calculate(StudentProfile student,
                                                  List<IntegrityCase> cases) {

        int count = cases.size();
        String level = count >= 3 ? "HIGH" : count == 2 ? "MEDIUM" : "LOW";

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudent(student);
        record.setTotalCases(count);
        record.setRiskLevel(level);

        return record;
    }
}
