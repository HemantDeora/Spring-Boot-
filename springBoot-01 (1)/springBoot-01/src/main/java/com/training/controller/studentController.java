package com.training.controller;

import com.training.Dto.StudentDto;

import com.training.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class studentController {

    private final StudentService studentService;



    @GetMapping("/student")
    public List<StudentDto> getStudentDto() {
        return studentService.getAllStudentDto();
    }

    @GetMapping("/student/{id}")

    public String getStudentByID(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

}
