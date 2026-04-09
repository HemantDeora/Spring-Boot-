package com.training.controller;

import com.training.Dto.AddStudentRequestDto;
import com.training.Dto.StudentDto;

import com.training.Dto.updateDto;
import com.training.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class studentController {

    private final StudentService studentService;



    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudentDto() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudentDto());
    }

    @GetMapping("/{id}")

    public ResponseEntity<StudentDto> getStudentByID(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
          return ResponseEntity.status(HttpStatus.CREATED).body(studentService.CreateNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentByID(@PathVariable long id){
        studentService.deleteStudentByID(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
   public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentByID(@PathVariable Long id, @RequestBody updateDto updateDto){
        return ResponseEntity.ok(studentService.updateStudentByID(id, updateDto));
    }

}














