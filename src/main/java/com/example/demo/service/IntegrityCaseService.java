package com.example.demo.service;

import com.example.demo.entity.IntegrityCase;
import java.util.List;

public interface IntegrityCaseService {

    IntegrityCase createCase(IntegrityCase integrityCase);

    IntegrityCase getCaseById(Long id);

    List<IntegrityCase> getAllCases();

    List<IntegrityCase> getCasesByStudentIdentifier(String studentIdentifier);

    IntegrityCase resolveCase(Long id);
}
