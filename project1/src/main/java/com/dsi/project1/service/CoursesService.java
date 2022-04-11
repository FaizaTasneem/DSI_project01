package com.dsi.project1.service;

import com.dsi.project1.model.Course;
import com.dsi.project1.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    @Autowired
    CoursesRepository coursesRepository;

    public List<Course> getAllCourses(){
        return coursesRepository.findAll();
    }

    public Course getCourseById(int id){
        return coursesRepository.getById(id);
    }

    public void saveCourse(Course course){
        coursesRepository.save(course);
    }

    public void deleteCourse(int id){
        coursesRepository.deleteById(id);
    }

    public void updateCourse(Course course, int id){
        coursesRepository.findById(id).map(c -> {
            c.setName(course.getName());
            return coursesRepository.save(course);
        }).orElseGet(() -> {
            course.setId(id);
            return coursesRepository.save(course);
        });
    }
}
