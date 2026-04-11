package com.training.service;

import com.training.Dto.Addcourserequestdto;
import com.training.Dto.CourseDto;
import com.training.Dto.Updatecoursedto;

import java.net.URI;
import java.util.List;

public interface CourseService {
    List<CourseDto> getAllCourses();


    CourseDto addCourse(Addcourserequestdto addcourserequestdto);

    CourseDto getCourseByID(Long id);

    void deleteCourseByID(long id);


    CourseDto updateCourseByID(Long id, Updatecoursedto updatecoursedto);

    CourseDto updateCourse(Long id, Updatecoursedto updatecoursedto);
}
