package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "integrity_cases")
@Data
public class IntegrityCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentProfile studentProfile;
    
    @Column(name = "course_code", nullable = false)
    private String courseCode;
    
    @Column(name = "instructor_name", nullable = false)
    private String instructorName;
    
    @Column(nullable = false)
    private String description;
    
    @Column(name = "incident_date", nullable = false)
    private LocalDate incidentDate;
    
    @Column(nullable = false)
    private String status = "OPEN";
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @OneToMany(mappedBy = "integrityCase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EvidenceRecord> evidences = new ArrayList<>();
    
    @OneToMany(mappedBy = "integrityCase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PenaltyAction> penalties = new ArrayList<>();
    
    @PrePersist
    protected void onCreate() {
        if (status == null) {
            status = "OPEN";
        }
        createdAt = LocalDateTime.now();
    }
}