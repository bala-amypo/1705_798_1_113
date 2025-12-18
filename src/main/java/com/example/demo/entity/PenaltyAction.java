package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PenaltyAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private IntegrityCase integrityCase;

    private String penaltyType;
    private String details;
    private String issuedBy;
    private LocalDateTime issuedAt;

    @PrePersist
    void onCreate() {
        issuedAt = LocalDateTime.now();
    }

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public IntegrityCase getIntegrityCase() {
        return integrityCase;
    }

    public String getPenaltyType() {
        return penaltyType;
    }

    public String getDetails() {
        return details;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setIntegrityCase(IntegrityCase integrityCase) {
        this.integrityCase = integrityCase;
    }

    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }
}
