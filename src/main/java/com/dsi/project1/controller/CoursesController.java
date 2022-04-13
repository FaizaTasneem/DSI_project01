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
    public Course getCourseById(@PathVariable("id")int id){
        return coursesService.getCourseById(id);
    }

    @PostMapping("/create")
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
    @PutMapping("/{courseId}/addstd/{studentId}")
    public Course enrollStudentToCourse(@PathVariable("courseId")int cid, @PathVariable("studentId") int sid){
        return coursesService.enrollStudent(cid,sid);
    }
    @PutMapping ("/{courseId}/delstd/{studentId}")
    public Course removeStudentFromCourse(@PathVariable("courseId")int cid, @PathVariable("studentId") int sid){
        return coursesService.removeStudent(cid,sid);
    }

    @PutMapping("/{courseId}/adddept/{deptId}")
    public Course addToDept(@PathVariable("courseId")int cid, @PathVariable("deptId") int did){
        return coursesService.addToDept(cid,did);
    }

    @PutMapping ("/{courseId}/deldept/{deptId}")
    public Course removeFromDept(@PathVariable("courseId")int cid, @PathVariable("deptId") int did){
        return coursesService.removeFromDept(cid,did);
    }


}
