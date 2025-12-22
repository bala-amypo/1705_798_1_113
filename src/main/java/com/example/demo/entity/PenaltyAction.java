package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PenaltyAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long caseId;
    private String penaltyType;
    private String description;

    public PenaltyAction() {}

    public PenaltyAction(Long caseId, String penaltyType, String description) {
        this.caseId = caseId;
        this.penaltyType = penaltyType;
        this.description = description;
    }

    public Long getId() { return id; }
    public Long getCaseId() { return caseId; }
    public String getPenaltyType() { return penaltyType; }
    public String getDescription() { return description; }

    public void setId(Long id) { this.id = id; }
    public void setCaseId(Long caseId) { this.caseId = caseId; }
    public void setPenaltyType(String penaltyType) { this.penaltyType = penaltyType; }
    public void setDescription(String description) { this.description = description; }
}
