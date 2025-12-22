package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.PenaltyAction;

import java.util.List;

public interface PenaltyActionRepository
        extends JpaRepository<PenaltyAction, Long> {

    List<PenaltyAction> findByIntegrityCaseId(Long id);
}
