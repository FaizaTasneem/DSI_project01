package com.dsi.project1.service;

import com.dsi.project1.model.Course;
import com.dsi.project1.model.Student;
import com.dsi.project1.repository.CoursesRepository;
import com.dsi.project1.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    StudentsRepository studentsRepository;


    public List<Course> getAllCourses(){
        return coursesRepository.findAll();
    }

    public Course getCourseById(int id){
        return coursesRepository.findById(id).get();
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

    public Course enrollStudent(int courseId, int studentId){
        Course course = coursesRepository.findById(courseId).get();
        Student student = studentsRepository.findById(studentId).get();
        course.enrollStudent(student);
        return coursesRepository.save(course);
    }


}
