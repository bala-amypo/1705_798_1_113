package com.example.demo.service;

import com.example.demo.entity.StudentProfile;

import java.util.List;

public interface StudentProfileService {

    StudentProfile createStudent(StudentProfile studentProfile);

    StudentProfile getStudentById(Long id);

    StudentProfile updateRepeatOffenderStatus(Long id);

    List<StudentProfile> getAllStudents();

    StudentProfile getStudentByStudentIdentifier(String studentIdentifier);
}
