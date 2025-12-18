package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.IntegrityCaseService;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.entity.IntegrityCase;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository repo;

    public IntegrityCaseServiceImpl(IntegrityCaseRepository repo) {
        this.repo = repo;
    }

    public IntegrityCase createCase(IntegrityCase c) {
        return repo.save(c);
    }
}
