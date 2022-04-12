package com.dsi.project1.model;

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
@Table(name = "courses")
public class Course {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    @ManyToMany
    @JoinTable(
            name = "students_enrolled",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> enrolledStudents = new HashSet<>();

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student){
        enrolledStudents.add(student);
    }

}
