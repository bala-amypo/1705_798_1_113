package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    private final StudentProfileService studentService;

    public StudentProfileController(StudentProfileService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ApiResponse create(@RequestBody StudentProfile studentProfile) {
        StudentProfile saved = studentService.createStudent(studentProfile);
        return new ApiResponse(true, "Created", saved);
    }

    @GetMapping("/{id}")
    public StudentProfile getById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentProfile> list() {
        return studentService.getAllStudents();
    }

    @PutMapping("/{id}/repeat")
    public ApiResponse updateRepeat(@PathVariable Long id) {
        StudentProfile updated = studentService.updateRepeatOffenderStatus(id);
        return new ApiResponse(true, "Repeat offender status recalculated", updated);
    }
}
