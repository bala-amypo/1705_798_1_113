package com.example.demo.controller;
n
import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService studentService;

    public StudentProfileController(StudentProfileService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentProfile createStudent(@RequestBody StudentProfile student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/{studentId}/repeat-status")
    public StudentProfile updateRepeatStatus(@PathVariable Long studentId) {
        return studentService.updateRepeatStatus(studentId);
    }

    @GetMapping("/lookup/{studentId}")
    public StudentProfile findByStudentIdentifier(@PathVariable String studentId) {
        return studentService.findByStudentIdentifier(studentId);
    }
}
