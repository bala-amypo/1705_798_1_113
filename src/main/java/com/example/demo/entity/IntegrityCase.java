package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "integrity_cases")
public class IntegrityCase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private StudentProfile studentProfile;

    private String courseCode;
    private String instructorName;

    @Column(length = 2000)
    private String description;

    private String status = "OPEN";

    private LocalDate incidentDate;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "integrityCase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvidenceRecord> evidenceRecords = new ArrayList<>();

    @OneToMany(mappedBy = "integrityCase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PenaltyAction> penaltyActions = new ArrayList<>();

    public IntegrityCase() {}

    public Long getId() { return id; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public String getCourseCode() { return courseCode; }
    public String getInstructorName() { return instructorName; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public LocalDate getIncidentDate() { return incidentDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<EvidenceRecord> getEvidenceRecords() { return evidenceRecords; }
    public List<PenaltyAction> getPenaltyActions() { return penaltyActions; }

    public void setId(Long id) { this.id = id; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public void setInstructorName(String instructorName) { this.instructorName = instructorName; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
    public void setIncidentDate(LocalDate incidentDate) { this.incidentDate = incidentDate; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setEvidenceRecords(List<EvidenceRecord> evidenceRecords) { this.evidenceRecords = evidenceRecords; }
    public void setPenaltyActions(List<PenaltyAction> penaltyActions) { this.penaltyActions = penaltyActions; }
}
