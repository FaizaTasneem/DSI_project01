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
@Table(name = "courses")
public class Course {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private Department department;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Section> sections = new ArrayList<>();

    //@JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "students_enrolled",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> enrolledStudents = new ArrayList<>();

    public void enrollStudent(Student student){
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public void addToDept(Department dept){
        department = dept;
    }

    public void deleteSection(Section section) {
        sections.remove(section);
    }
}
