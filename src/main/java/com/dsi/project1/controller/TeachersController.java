package com.dsi.project1.controller;


import com.dsi.project1.model.Course;
import com.dsi.project1.model.Teacher;
import com.dsi.project1.service.TeachersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    TeachersServices teachersServices;
    @GetMapping("/all")
    public List<Teacher> getAllTeacher(){
        return teachersServices.getAllTeachers();
    }

    @GetMapping("/{tid}")
    public Teacher getTeachersById(@PathVariable("tid") int tid){
        return teachersServices.getTeachersById(tid);
    }

    @PostMapping
    public void saveTeacher(@RequestBody Teacher teacher){
        teachersServices.saveTeachers(teacher);
    }

    @DeleteMapping( "/{tid}")
    public void deleteTeacher(@PathVariable("tid") int tid){
        teachersServices.deleteTeacher(tid);
    }

    @PutMapping("/{tid}")
    public void updateTeacher(@RequestBody Teacher teacher, @PathVariable("tid") int tid){
        teachersServices.updateTeacher(teacher,tid);
    }

    @PutMapping("/{tid}/adddept/{deptId}")
    public Teacher addToDept(@PathVariable("tid")int tid, @PathVariable("deptId") int did){
        return teachersServices.addToDept(tid,did);
    }

    @PutMapping ("/{courseId}/deldept/{deptId}")
    public Teacher removeFromDept(@PathVariable("tid")int tid, @PathVariable("deptId") int did){
        return teachersServices.removeFromDept(tid,did);
    }

}
