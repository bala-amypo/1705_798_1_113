package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        return repo.save(student);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public StudentProfile updateRepeatStatus(Long studentId) {
        StudentProfile student = repo.findById(studentId).orElse(null);
        if (student != null) {
            student.setRepeatOffender(true); // simple demo logic
            return repo.save(student);
        }
        return null;
    }

    @Override
    public StudentProfile findByStudentIdentifier(String studentId) {
        return repo.findByStudentIdentifier(studentId).orElse(null);
    }
}
