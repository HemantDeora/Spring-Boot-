package com.training.service.impl;

import com.training.Dto.StudentDto;
import com.training.Entity.Student;
import com.training.Repo.StudentRepo;
import com.training.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceimpl implements StudentService {

    private final StudentRepo  studentRepo;

    @Override
    public List<StudentDto> getAllStudentDto() {
        List<Student> students = studentRepo.findAll();
        return students
                .stream()
                .map(Student -> new StudentDto(Student.getId(),Student.getName(),Student.getEmail()))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return null;
    }
}
