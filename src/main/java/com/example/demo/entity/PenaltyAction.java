package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "penalty_actions")
public class PenaltyAction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private IntegrityCase integrityCase;

    private String penaltyType;
    @Column(length = 2000)
    private String details;

    private String issuedBy;
    private LocalDateTime issuedAt;

    public PenaltyAction() {}

    @PrePersist
    public void prePersist() {
        if (issuedAt == null) issuedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public IntegrityCase getIntegrityCase() { return integrityCase; }
    public String getPenaltyType() { return penaltyType; }
    public String getDetails() { return details; }
    public String getIssuedBy() { return issuedBy; }
    public LocalDateTime getIssuedAt() { return issuedAt; }

    public void setId(Long id) { this.id = id; }
    public void setIntegrityCase(IntegrityCase integrityCase) { this.integrityCase = integrityCase; }
    public void setPenaltyType(String penaltyType) { this.penaltyType = penaltyType; }
    public void setDetails(String details) { this.details = details; }
    public void setIssuedBy(String issuedBy) { this.issuedBy = issuedBy; }
    public void setIssuedAt(LocalDateTime issuedAt) { this.issuedAt = issuedAt; }
}
