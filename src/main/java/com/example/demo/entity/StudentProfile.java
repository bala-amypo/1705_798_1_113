package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String studentId;

    private String name;
    private String email;
    private String program;

    @Column(nullable = false)
    private Integer yearLevel;

    private Boolean repeatOffender = false;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "studentProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IntegrityCase> integrityCases = new ArrayList<>();

    public StudentProfile() {}
    public StudentProfile(String studentId, String name, String email, String program, Integer yearLevel) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.program = program;
        this.yearLevel = yearLevel;
    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
        if (repeatOffender == null) repeatOffender = false;
    }

    public Long getId() { return id; }
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getProgram() { return program; }
    public Integer getYearLevel() { return yearLevel; }
    public Boolean getRepeatOffender() { return repeatOffender; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<IntegrityCase> getIntegrityCases() { return integrityCases; }

    public void setId(Long id) { this.id = id; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setProgram(String program) { this.program = program; }
    public void setYearLevel(Integer yearLevel) { this.yearLevel = yearLevel; }
    public void setRepeatOffender(Boolean repeatOffender) { this.repeatOffender = repeatOffender; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setIntegrityCases(List<IntegrityCase> integrityCases) { this.integrityCases = integrityCases; }
}
