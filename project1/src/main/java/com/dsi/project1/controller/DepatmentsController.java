package com.dsi.project1.controller;

import com.dsi.project1.model.Department;
import com.dsi.project1.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepatmentsController {
    @Autowired
    DepartmentsService departmentsService;

    @GetMapping("/alldepts")
    public List<Department> getAllDepts(){
        return departmentsService.getAllDepts();
    }

    @GetMapping("/{id}")
    public Department getDeptById(@PathVariable("id") int id){
        return departmentsService.getDeptById(id);
    }

    @PostMapping("/")
    public void saveDept(@RequestBody Department dept){
        departmentsService.saveDept(dept);
    }

    @DeleteMapping("/{id}")
    public void deleteDept(@PathVariable("id") int id){
        departmentsService.deleteDept(id);
    }

    @PutMapping("/{id}")
    public void updateDept(@RequestBody Department dept, @PathVariable("id") int id){
        departmentsService.updateDept(dept,id);
    }
}
