package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidence_records")
public class EvidenceRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private IntegrityCase integrityCase;

    private String evidenceType;
    @Column(length = 4000)
    private String content;

    private String submittedBy;
    private LocalDateTime submittedAt;

    public EvidenceRecord() {}

    @PrePersist
    public void prePersist() {
        if (submittedAt == null) submittedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public IntegrityCase getIntegrityCase() { return integrityCase; }
    public String getEvidenceType() { return evidenceType; }
    public String getContent() { return content; }
    public String getSubmittedBy() { return submittedBy; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }

    public void setId(Long id) { this.id = id; }
    public void setIntegrityCase(IntegrityCase integrityCase) { this.integrityCase = integrityCase; }
    public void setEvidenceType(String evidenceType) { this.evidenceType = evidenceType; }
    public void setContent(String content) { this.content = content; }
    public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
}
