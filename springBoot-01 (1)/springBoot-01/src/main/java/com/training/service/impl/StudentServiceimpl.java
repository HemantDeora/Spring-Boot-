package com.training.service.impl;

import com.training.Dto.AddStudentRequestDto;
import com.training.Dto.StudentDto;
import com.training.Dto.updateDto;
import com.training.Entity.Student;
import com.training.Repo.StudentRepo;
import com.training.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceimpl implements StudentService {

    private final StudentRepo studentRepo;
    public final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudentDto() {
        List<Student> students = studentRepo.findAll();
        return students
                .stream()
                .map(Student -> new StudentDto(Student.getId(), Student.getName(), Student.getEmail()))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id  " + id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto CreateNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepo.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentByID(long id) {
        if (!studentRepo.existsById(id)) {
            throw new IllegalArgumentException("Student not found with id  " + id);
        } else
            studentRepo.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id  " + id));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepo.save(student);
        return modelMapper.map(student, StudentDto.class);

    }

    @Override
    public StudentDto updateStudentByID(Long id,  updateDto addStudentRequestDto) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id  " + id));

        if(addStudentRequestDto.getName() != null){
            student.setName(addStudentRequestDto.getName());
        }
        if (addStudentRequestDto.getEmail() != null){
            student.setEmail(addStudentRequestDto.getEmail());
        }

        studentRepo.save(student);
        return modelMapper.map(student, StudentDto.class);


    }
}





