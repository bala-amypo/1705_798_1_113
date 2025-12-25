package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidence_records")
public class EvidenceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private IntegrityCase integrityCase;

    private String evidenceType;
    private String content;
    private String submittedBy;
    private LocalDateTime submittedAt = LocalDateTime.now();

    public EvidenceRecord() {}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public IntegrityCase getIntegrityCase() { return integrityCase; }
    public void setIntegrityCase(IntegrityCase integrityCase) { this.integrityCase = integrityCase; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
}
