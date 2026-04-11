package com.training.service;

import com.training.Dto.Addcourserequestdto;
import com.training.Dto.CourseDto;

import java.net.URI;
import java.util.List;

public interface CourseService {
    List<CourseDto> getAllCourses();


    CourseDto addCourse(Addcourserequestdto addcourserequestdto);
}
