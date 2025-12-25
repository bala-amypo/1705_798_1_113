package com.example.demo.service;

import com.example.demo.entity.RepeatOffenderRecord;
import java.util.List;   // ✅ ADD THIS

public interface RepeatOffenderRecordService {

    RepeatOffenderRecord updateOrCreateRecord(Long studentId);

    List<RepeatOffenderRecord> getAllRecords();
}
