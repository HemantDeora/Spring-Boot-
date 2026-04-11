package com.training.controller;

import com.training.Dto.Addcourserequestdto;
import com.training.Dto.CourseDto;
import com.training.Dto.Updatecoursedto;
import com.training.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")   // ✅ Base URL (IMPORTANT)
@RequiredArgsConstructor
public class CoursesController {   // ✅ Proper naming

    private final CourseService courseService;

    // 🔵 GET ALL COURSES
    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourse() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    // 🔵 GET COURSE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseByID(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseByID(id));
    }

    // 🔵 CREATE COURSE
    @PostMapping
    public ResponseEntity<CourseDto> addCourse(
            @RequestBody Addcourserequestdto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(courseService.addCourse(dto));
    }

    // 🔵 DELETE COURSE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseByID(@PathVariable Long id) {

        courseService.deleteCourseByID(id);

        return ResponseEntity.noContent().build(); // ✅ 204
    }

    @PutMapping("/{id}")
    public  ResponseEntity<CourseDto> updateCourseByID(@PathVariable Long id, @RequestBody Updatecoursedto updatecoursedto){
        return ResponseEntity.ok(courseService.updateCourseByID(id,updatecoursedto));
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<CourseDto> updateCourse(@PathVariable Long id, @RequestBody Updatecoursedto updatecoursedto){
        return ResponseEntity.ok(courseService.updateCourse(id,updatecoursedto));
    }


}