package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    // POST /api/students/ – Create student profile
    @PostMapping("/")
    public StudentProfile create(@RequestBody StudentProfile student) {
        return studentProfileService.createStudent(student);
    }

    // GET /api/students/{id} – Get student by ID
    @GetMapping("/{id}")
    public StudentProfile getById(@PathVariable Long id) {
        return studentProfileService.getStudentById(id);
    }

    // GET /api/students/ – List all students
    @GetMapping("/")
    public List<StudentProfile> getAll() {
        return studentProfileService.getAllStudents();
    }

    // PUT /api/students/{studentId}/repeat-status – Update repeat offender status
    @PutMapping("/{studentId}/repeat-status")
    public StudentProfile updateRepeatStatus(@PathVariable Long studentId) {
        return studentProfileService.updateRepeatOffenderStatus(studentId);
    }

    // GET /api/students/lookup/{studentId} – Find by student identifier
    @GetMapping("/lookup/{studentId}")
    public List<StudentProfile> lookupByStudentId(@PathVariable String studentId) {
        // basic example: filter in memory from all students
        return studentProfileService.getAllStudents().stream()
                .filter(s -> studentId.equals(s.getStudentId()))
                .toList();
    }
}
