package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import org.springframework.stereotype.Component;  // ← ADD THIS LINE

import java.util.List;

@Component  // ← ADD THIS LINE
public class RepeatOffenderCalculator {
    
    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile student, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setTotalCases(cases.size());
        
        int severityLevel = cases.size();
        if (severityLevel == 1) {
            record.setFlagSeverity("LOW");
        } else if (severityLevel == 2 || severityLevel == 3) {
            record.setFlagSeverity("MEDIUM");
        } else {
            record.setFlagSeverity("HIGH");
        }
        
        return record;
    }
}
