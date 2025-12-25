package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentProfileController {
    
    private final StudentProfileService studentProfileService;
    
    @PostMapping
    public ResponseEntity<StudentProfile> createStudent(@RequestBody StudentProfile studentProfile) {
        StudentProfile created = studentProfileService.createStudent(studentProfile);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
        StudentProfile student = studentProfileService.getStudentById(id);
        return ResponseEntity.ok(student);
    }
    
    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        List<StudentProfile> students = studentProfileService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    
    @PutMapping("/{id}/repeat-offender")
    public ResponseEntity<StudentProfile> updateRepeatOffenderStatus(@PathVariable Long id) {
        StudentProfile updated = studentProfileService.updateRepeatOffenderStatus(id);
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/student-id/{studentId}")
    public ResponseEntity<StudentProfile> getStudentByStudentId(@PathVariable String studentId) {
        StudentProfile student = studentProfileService.getStudentByStudentId(studentId);
        return ResponseEntity.ok(student);
    }
}