package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EvidenceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long caseId;
    private String evidenceType;
    private String details;

    public EvidenceRecord() {}

    public EvidenceRecord(Long caseId, String evidenceType, String details) {
        this.caseId = caseId;
        this.evidenceType = evidenceType;
        this.details = details;
    }

    public Long getId() { return id; }
    public Long getCaseId() { return caseId; }
    public String getEvidenceType() { return evidenceType; }
    public String getDetails() { return details; }

    public void setId(Long id) { this.id = id; }
    public void setCaseId(Long caseId) { this.caseId = caseId; }
    public void setEvidenceType(String evidenceType) { this.evidenceType = evidenceType; }
    public void setDetails(String details) { this.details = details; }
}
