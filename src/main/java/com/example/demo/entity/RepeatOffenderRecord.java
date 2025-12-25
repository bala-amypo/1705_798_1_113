package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "repeat_offender_records")
@Data
public class RepeatOffenderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false, unique = true)
    private StudentProfile studentProfile;
    
    @Column(name = "total_cases", nullable = false)
    private Integer totalCases = 0;
    
    @Column(name = "flag_severity", nullable = false)
    private String flagSeverity = "LOW";
    
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated = LocalDateTime.now();
    
    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        lastUpdated = LocalDateTime.now();
    }
}