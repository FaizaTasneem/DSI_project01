package com.dsi.project1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private String bloodgrp;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private Department department;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private List<Course> courses = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "totalStudents")
    private List<Section> sections = new ArrayList<>();


    public void addToDept(Department dept){
        department = dept;
    }

}
