package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Existing fields
    private Long studentId;
    private int repeatCount;

    // New fields to match calculator usage
    @ManyToOne
    private StudentProfile studentProfile;

    private int totalCases;
    private String flagSeverity;

    public RepeatOffenderRecord() {}

    public RepeatOffenderRecord(Long studentId) {
        this.studentId = studentId;
        this.repeatCount = 0;
    }

    // Getters
    public Long getId() { return id; }
    public Long getStudentId() { return studentId; }
    public int getRepeatCount() { return repeatCount; }
    public StudentProfile getStudentProfile() { return studentProfile; }
    public int getTotalCases() { return totalCases; }
    public String getFlagSeverity() { return flagSeverity; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public void setRepeatCount(int repeatCount) { this.repeatCount = repeatCount; }
    public void setStudentProfile(StudentProfile studentProfile) { this.studentProfile = studentProfile; }
    public void setTotalCases(int totalCases) { this.totalCases = totalCases; }
    public void setFlagSeverity(String flagSeverity) { this.flagSeverity = flagSeverity; }
}
