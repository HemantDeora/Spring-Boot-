package com.training.service.impl;

import com.training.Dto.Addcourserequestdto;
import com.training.Dto.CourseDto;
import com.training.Dto.Updatecoursedto;
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
       Course course = modelMapper.map(addcourserequestdto, Course.class);
       Course saved = courseRepo.save(course);
       return modelMapper.map(saved, CourseDto.class);
    }

    @Override
    public CourseDto getCourseByID(Long id) {
       Course course = courseRepo.findById(id).orElseThrow(() -> new  IllegalArgumentException("Course not found"));
       return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public void deleteCourseByID(long id) {
        Course course = courseRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found "));
        courseRepo.delete(course);
    }



    @Override
    public CourseDto updateCourseByID(Long id, Updatecoursedto updatecoursedto) {
        Course course = courseRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found "));
        course.setCourseName(updatecoursedto.getCourseName());
        course.setCourseDuration(updatecoursedto.getCourseDuration());
        course.setCourseTime(updatecoursedto.getCourseTime());

        Course saved = courseRepo.save(course);
        return modelMapper.map(saved, CourseDto.class);
    }

    @Override
    public CourseDto updateCourse(Long id, Updatecoursedto updatecoursedto) {
        Course course = courseRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found "));

        if(updatecoursedto.getCourseName() !=null){
            course.setCourseName(updatecoursedto.getCourseName());
        }
        if(updatecoursedto.getCourseDuration() !=null){
            course.setCourseDuration(updatecoursedto.getCourseDuration());
        }
        if(updatecoursedto.getCourseTime() !=null){
            course.setCourseTime(updatecoursedto.getCourseTime());
        }
        Course saved = courseRepo.save(course);
        return modelMapper.map(saved, CourseDto.class);
    }
}
