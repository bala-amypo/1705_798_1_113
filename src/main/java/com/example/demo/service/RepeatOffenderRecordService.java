package com.example.demo.service;

import com.example.demo.entity.RepeatOffenderRecord;
import java.util.List;

public interface RepeatOffenderRecordService {
    RepeatOffenderRecord recalculateRepeatOffender(Long studentId);
    RepeatOffenderRecord getRecordForStudent(Long studentId);
    List<RepeatOffenderRecord> getAllRepeatOffenders();
}
