package com.dsi.project1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sections")
public class Section {

    @Id
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @ManyToMany
    @JoinTable(
            name = "students_in_section",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> totalStudents = new ArrayList<>();

    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addToCourse(Course course) {
        this.course = course;
    }

    public void addStudent(Student student){
        totalStudents.add(student);
    }

    public void removeStudent(Student student) {
        totalStudents.remove(student);
    }
}
