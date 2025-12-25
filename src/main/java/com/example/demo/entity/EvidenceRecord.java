package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidence_records")
@Data
public class EvidenceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false)
    private IntegrityCase integrityCase;
    
    @Column(name = "evidence_type", nullable = false)
    private String evidenceType;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    
    @Column(name = "submitted_by", nullable = false)
    private String submittedBy;
    
    @Column(name = "submitted_at")
    private LocalDateTime submittedAt = LocalDateTime.now();
    
    @PrePersist
    protected void onCreate() {
        submittedAt = LocalDateTime.now();
    }
}