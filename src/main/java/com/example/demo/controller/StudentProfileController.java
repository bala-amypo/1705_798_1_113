package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public ResponseEntity<StudentProfile> createStudent(
            @RequestBody StudentProfile studentProfile) {

        return ResponseEntity.status(201)
                .body(studentProfileService.createStudent(studentProfile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(
                studentProfileService.getStudentById(id)
        );
    }

    @GetMapping("/lookup/{studentId}")
    public ResponseEntity<StudentProfile> getStudentByStudentIdentifier(
            @PathVariable String studentId) {

        return ResponseEntity.ok(
                studentProfileService.getStudentByStudentIdentifier(studentId)
        );
    }

    @PutMapping("/{id}/repeat-offender")
    public ResponseEntity<StudentProfile> markRepeatOffender(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                studentProfileService.updateRepeatOffenderStatus(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        return ResponseEntity.ok(
                studentProfileService.getAllStudents()
        );
    }
}