package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private StudentProfile studentProfile;

    private Integer totalCases;
    private String flagSeverity;

    // ✅ ADD
    private LocalDate firstIncidentDate;

    public void setFirstIncidentDate(LocalDate firstIncidentDate) {
        this.firstIncidentDate = firstIncidentDate;
    }

    public Integer getTotalCases() { return totalCases; }
    public String getFlagSeverity() { return flagSeverity; }
    public StudentProfile getStudentProfile() { return studentProfile; }
}
