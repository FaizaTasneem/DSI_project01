package com.dsi.project1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sections")
public class Section {

    @Id
    private int id;

    private String name;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    public void addToCourse(Course course) {
        this.course = course;
    }
}
