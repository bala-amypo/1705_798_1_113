package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_profiles")
@Data
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "student_id", unique = true, nullable = false)
    private String studentId;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String program;
    
    @Column(name = "year_level", nullable = false)
    private Integer yearLevel;
    
    @Column(name = "repeat_offender")
    private Boolean repeatOffender = false;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @OneToMany(mappedBy = "studentProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<IntegrityCase> integrityCases = new ArrayList<>();
    
    @OneToOne(mappedBy = "studentProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RepeatOffenderRecord repeatOffenderRecord;
    
    @PrePersist
    protected void onCreate() {
        if (repeatOffender == null) {
            repeatOffender = false;
        }
        createdAt = LocalDateTime.now();
    }
}