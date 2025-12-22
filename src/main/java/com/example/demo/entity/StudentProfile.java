package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentIdentifier;
    private String name;
    private boolean repeatOffender;

    public StudentProfile() {}

    public StudentProfile(String studentIdentifier, String name) {
        this.studentIdentifier = studentIdentifier;
        this.name = name;
        this.repeatOffender = false;
    }

    public Long getId() { return id; }
    public String getStudentIdentifier() { return studentIdentifier; }
    public String getName() { return name; }
    public boolean isRepeatOffender() { return repeatOffender; }

    public void setId(Long id) { this.id = id; }
    public void setStudentIdentifier(String studentIdentifier) { this.studentIdentifier = studentIdentifier; }
    public void setName(String name) { this.name = name; }
    public void setRepeatOffender(boolean repeatOffender) { this.repeatOffender = repeatOffender; }
}
