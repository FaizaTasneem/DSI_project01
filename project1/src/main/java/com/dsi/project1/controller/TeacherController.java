package com.dsi.project1.controller;
import com.dsi.project1.model.Teacher;
import com.dsi.project1.service.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TeacherController {

    @Autowired
    TeacherServices teacherServices;

    @GetMapping("/allteachers")
    public List<Teacher> getAllTeacher(){
        return teacherServices.getAllTeachers();
    }

    @GetMapping("/{tid}")
    public Teacher getTeachersById(@PathVariable("tid") int tid){
        return teacherServices.getTeachersById(tid);
    }

    @PostMapping("/addteacher")
    public void saveTeacher(@RequestBody Teacher teacher){
        teacherServices.saveTeachers(teacher);
    }
    @DeleteMapping("/{tid}")
    public void deleteTeacher(@PathVariable("tid") int tid){
        teacherServices.deleteTeacher(tid);
    }

    @PutMapping("/{tid}")
    public void updateTeacher(@RequestBody Teacher teacher, @PathVariable("tid") int tid){
        teacherServices.updateTeacher(teacher,tid);
    }
}
