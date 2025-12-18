package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔴 REQUIRED for repository query
    private String studentIdentifier;

    private String description;
    private String status;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentIdentifier(String studentIdentifier) {
        this.studentIdentifier = studentIdentifier;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
