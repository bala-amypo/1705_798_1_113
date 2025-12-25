package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RepeatOffenderCalculator {
    
    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile student, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setTotalCases(cases.size());
        record.setFlagSeverity(calculateSeverity(cases.size()));
        
        return record;
    }
    
    private String calculateSeverity(int caseCount) {
        if (caseCount == 0) {
            return "NONE";
        } else if (caseCount == 1) {
            return "LOW";
        } else if (caseCount == 2) {
            return "MEDIUM";
        } else if (caseCount == 3) {
            return "HIGH";
        } else {
            return "CRITICAL";
        }
    }
    
    public boolean isRepeatOffender(List<IntegrityCase> cases) {
        return cases.size() >= 2;
    }
    
    public int calculateOffenseScore(List<IntegrityCase> cases) {
        return cases.size() * 10; // Simple scoring system
    }
}