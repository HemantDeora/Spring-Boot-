package com.training.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="courses")
@Data
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;
    private String courseName;
    private String courseDuration;
    private String courseTime;

    @ManyToMany(mappedBy = "course")
    private List<Student> students;



}
