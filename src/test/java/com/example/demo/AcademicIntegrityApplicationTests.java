package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AcademicIntegrityApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcademicIntegrityApplication.class, args);
    }
}