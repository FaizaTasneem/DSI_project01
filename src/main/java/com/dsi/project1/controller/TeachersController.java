package com.dsi.project1.controller;


import com.dsi.project1.model.Course;
import com.dsi.project1.model.Teacher;
import com.dsi.project1.service.TeachersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class TeachersController {

    @Autowired
    TeachersServices teachersServices;

    @PutMapping("/{tid}/adddept/{deptId}")
    public Teacher addToDept(@PathVariable("tid")int tid, @PathVariable("deptId") int did){
        return teachersServices.addToDept(tid,did);
    }

    @PutMapping ("/{courseId}/deldept/{deptId}")
    public Teacher removeFromDept(@PathVariable("tid")int tid, @PathVariable("deptId") int did){
        return teachersServices.removeFromDept(tid,did);
    }

}
