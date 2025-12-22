package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String description;
    private String status;

    public IntegrityCase() {}

    public IntegrityCase(Long studentId, String description, String status) {
        this.studentId = studentId;
        this.description = description;
        this.status = status;
    }

    public Long getId() { return id; }
    public Long getStudentId() { return studentId; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
}
