package com.example.demo.entity;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "student_profile")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String studentIdentifier;

    private String name;
    private String email;
    private String program;
    private Integer yearLevel;

    @Column(nullable = false)
    private boolean repeatOffender = false;
    private LocalDateTime createdAt;

    public StudentProfile() {} 

    public StudentProfile(String studentIdentifier, String name, String email, String program, Integer yearLevel,
                         boolean repeatOffender, LocalDateTime createdAt) {
        this.studentIdentifier = studentIdentifier;
        this.name = name;
        this.email = email;
        this.program = program;
        this.yearLevel = yearLevel;
        this.repeatOffender = repeatOffender;
        this.createdAt = createdAt;
    }

    public Long getId() {
         return id;
          }
    public void setId(Long id) {
     this.id = id;
      }

    public String getStudentIdentifier() { 
        return studentIdentifier;
         }
    public void setStudentIdentifier(String studentIdentifier) { 
        this.studentIdentifier = studentIdentifier; 
        }

    public String getName() { 
        return name;
         }
    public void setName(String name) {
     this.name = name; 
     }

    public String getEmail() { 
        return email;
         }
    public void setEmail(String email) {
         this.email = email;
          }

    public String getProgram() {
         return program;
          }
    public void setProgram(String program) { 
    this.program = program; 
    }

    public Integer getYearLevel() {
     return yearLevel;
      }
    public void setYearLevel(Integer yearLevel) { 
        this.yearLevel = yearLevel;
         }

    public boolean isRepeatOffender() {
        return repeatOffender;
    }

    public void setRepeatOffender(boolean repeatOffender) {
        this.repeatOffender = repeatOffender;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}