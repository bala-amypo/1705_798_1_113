package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "repeat_offender_records")
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentProfile studentProfile;

    private int offenceCount;

    private String severityLevel;

    private LocalDate lastOffenceDate;

    // ---------- getters & setters ----------

    public Long getId() {
        return id;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public int getOffenceCount() {
        return offenceCount;
    }

    public void setOffenceCount(int offenceCount) {
        this.offenceCount = offenceCount;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public LocalDate getLastOffenceDate() {
        return lastOffenceDate;
    }

    public void setLastOffenceDate(LocalDate lastOffenceDate) {
        this.lastOffenceDate = lastOffenceDate;
    }
}
