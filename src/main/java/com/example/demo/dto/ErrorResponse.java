package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    
    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }
} 