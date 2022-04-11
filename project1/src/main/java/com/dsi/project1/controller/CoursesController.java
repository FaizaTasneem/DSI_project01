package com.dsi.project1.controller;

import com.dsi.project1.model.Course;
import com.dsi.project1.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @GetMapping("/allcourses")
    public List<Course> getAllCourses(){
        return coursesService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(int id){
        return coursesService.getCourseById(id);
    }

    @PostMapping("/")
    public void saveCourse(@RequestBody Course course){
        coursesService.saveCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") int id){
        coursesService.deleteCourse(id);
    }

    @PutMapping("/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable("id") int id){
        coursesService.updateCourse(course,id);
    }
}
