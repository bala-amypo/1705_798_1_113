package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "penalty_actions")
@Data
public class PenaltyAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false)
    private IntegrityCase integrityCase;
    
    @Column(name = "penalty_type", nullable = false)
    private String penaltyType;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String details;
    
    @Column(name = "issued_by", nullable = false)
    private String issuedBy;
    
    @Column(name = "issued_at")
    private LocalDateTime issuedAt = LocalDateTime.now();
    
    @PrePersist
    protected void onCreate() {
        issuedAt = LocalDateTime.now();
    }
}