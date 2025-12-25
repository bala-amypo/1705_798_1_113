package com.example.demo.service;

import com.example.demo.entity.RepeatOffenderRecord;

public interface RepeatOffenderRecordService {

    RepeatOffenderRecord recalculate(Long studentId);

    RepeatOffenderRecord updateOrCreateRecord(Long studentId);
    List<RepeatOffenderRecord> getAllRecords();

}
