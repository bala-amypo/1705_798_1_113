package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penalties")
public class PenaltyActionController {

    private final PenaltyActionService penaltyService;

    public PenaltyActionController(PenaltyActionService penaltyService) {
        this.penaltyService = penaltyService;
    }

    @PostMapping
    public ApiResponse add(@RequestBody PenaltyAction penaltyAction) {
        PenaltyAction saved = penaltyService.addPenalty(penaltyAction);
        return new ApiResponse(true, "Penalty added", saved);
    }
}
