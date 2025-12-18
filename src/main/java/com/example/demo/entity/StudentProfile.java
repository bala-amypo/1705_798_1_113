package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔴 REQUIRED FOR findByStudentIdentifier
    @Column(unique = true, nullable = false)
    private String studentIdentifier;

    private String name;
    private String email;
    private String department;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentIdentifier(String studentIdentifier) {
        this.studentIdentifier = studentIdentifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
