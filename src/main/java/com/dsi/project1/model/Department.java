package com.dsi.project1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "depts")
public class Department {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Course> courses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Student> students = new ArrayList<>();

//    public void addCourse(Course course){
//        courses.add(course);
//    }

    public void deleteCourse(Course course){
        courses.remove(course);
    }

    public void deleteStudent(Student student){
        students.remove(student);
    }
}
