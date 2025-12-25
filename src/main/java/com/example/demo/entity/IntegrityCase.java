package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;
import java.util.List;

@Entity
@Table(name = "integrity_cases")
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String violationType;
    private LocalDate violationDate;
    private LocalDateTime reportedAt;

    @ManyToOne
    private StudentProfile student;

    @OneToMany(mappedBy = "integrityCase")
    private List<EvidenceRecord> evidenceRecords;

    // getters & setters
}
