package com.training.service;

import com.training.Dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudentDto();

    StudentDto getStudentById(Long id);
}
