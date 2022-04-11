package com.dsi.project1.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Setter
@Getter
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tid;
    private String name;
    private String dept;
    private String gender;
    private int age;

    public Teacher(int tid, String name, String dept, String gender, int age) {
        this.tid = tid;
        this.name = name;
        this.dept = dept;
        this.gender = gender;
        this.age = age;
    }

    public Teacher() {

    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
