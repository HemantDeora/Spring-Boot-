package com.training.service;

import com.training.Dto.AddStudentRequestDto;
import com.training.Dto.StudentDto;
import com.training.Dto.updateDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudentDto();

    StudentDto getStudentById(Long id);

    StudentDto CreateNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentByID(long id);


    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updateStudentByID(Long id, updateDto updateDto);

    StudentDto addCourseToStudent(Long studentID, Long courseId);
}
