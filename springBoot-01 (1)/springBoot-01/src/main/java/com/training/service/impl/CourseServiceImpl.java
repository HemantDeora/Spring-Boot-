package com.training.service.impl;

import com.training.Dto.Addcourserequestdto;
import com.training.Dto.CourseDto;
import com.training.Entity.Course;
import com.training.Repo.CourseRepo;
import com.training.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepo.findAll();
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .toList();
    }

    @Override
    public CourseDto addCourse(Addcourserequestdto addcourserequestdto) {
       Course Newcourse = modelMapper.map(addcourserequestdto, Course.class);
       Course course =   courseRepo.save(Newcourse);
        return modelMapper.map(course, CourseDto.class);
    }
}
