package com.example.demo.controller;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/penalties")
@RequiredArgsConstructor
public class PenaltyActionController {
    
    private final PenaltyActionService penaltyActionService;
    
    @PostMapping
    public ResponseEntity<PenaltyAction> addPenalty(@RequestBody PenaltyAction penaltyAction) {
        PenaltyAction created = penaltyActionService.addPenalty(penaltyAction);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}