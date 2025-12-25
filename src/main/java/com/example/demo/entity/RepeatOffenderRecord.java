package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;

import java.util.List;   
import org.springframework.stereotype.Service;

@Entity
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private StudentProfile studentProfile;

    private Integer totalCases;
    private String flagSeverity;

    // ✅ ADD
    private LocalDate firstIncidentDate;

    public void setFirstIncidentDate(LocalDate firstIncidentDate) {
        this.firstIncidentDate = firstIncidentDate;
    }

    public Integer getTotalCases() { return totalCases; }
    public String getFlagSeverity() { return flagSeverity; }
    public StudentProfile getStudentProfile() { return studentProfile; }
}
