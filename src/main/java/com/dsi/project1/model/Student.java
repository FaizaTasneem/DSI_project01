package com.dsi.project1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String gender;
    private int age;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Course> courses = new HashSet<>();

    public Set<Course> getCourses() {
        return courses;
    }


}
