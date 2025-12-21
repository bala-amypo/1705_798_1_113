package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "repeat_offender_records")
public class RepeatOffenderRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private StudentProfile studentProfile;

    private Integer totalCases;
    private LocalDate firstIncidentDate;
    private String flagSeverity; // LOW, MEDIUM, HIGH

    public RepeatOffenderRecord() {}

    public Long getId() { return id; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public Integer getTotalCases() { return totalCases; }
    public LocalDate getFirstIncidentDate() { return firstIncidentDate; }
    public String getFlagSeverity() { return flagSeverity; }

    public void setId(Long id) { this.id = id; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public void setTotalCases(Integer totalCases) { this.totalCases = totalCases; }
    public void setFirstIncidentDate(LocalDate firstIncidentDate) { this.firstIncidentDate = firstIncidentDate; }
    public void setFlagSeverity(String flagSeverity) { this.flagSeverity = flagSeverity; }
}
