package com.dsi.project1.controller;

import com.dsi.project1.model.Course;
import com.dsi.project1.model.Student;
import com.dsi.project1.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    StudentsService studentsService;

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentsService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return studentsService.getStudentById(id);
    }

    @PostMapping
    public void saveStudent(@RequestBody Student student){
        studentsService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentsService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable("id") int id){
        studentsService.updateStudent(student,id);
    }

    @PutMapping("/{stdid}/adddept/{deptId}")
    public Student addToDept(@PathVariable("stdid")int sid, @PathVariable("deptId") int did){
        return studentsService.addToDept(sid,did);
    }

    @PutMapping ("/{courseId}/deldept/{deptId}")
    public Student removeFromDept(@PathVariable("stdid")int sid, @PathVariable("deptId") int did){
        return studentsService.removeFromDept(sid,did);
    }

}
