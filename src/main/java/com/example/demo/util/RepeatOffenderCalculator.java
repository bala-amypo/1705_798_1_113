package com.example.demo.util;

import com.example.demo.entity.RepeatOffenderRecord;

public class RepeatOffenderCalculator {

    public static String calculateSeverity(RepeatOffenderRecord record) {
        int count = record.getOffenceCount();

        if (count <= 1) return "LOW";
        if (count == 2) return "MEDIUM";
        return "HIGH";
    }
}
