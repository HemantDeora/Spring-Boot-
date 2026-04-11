package com.training.controller;

import com.training.Dto.Addcourserequestdto;
import com.training.Dto.CourseDto;
import com.training.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class coursesController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDto>> getCourse(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseDto> addCourse(@RequestBody Addcourserequestdto addcourserequestdto){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(addcourserequestdto));
    }

}
