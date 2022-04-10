package com.dsi.project1.controller;

import com.dsi.project1.model.Departments;
import com.dsi.project1.service.DepartmentsService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepatmentsController {
    @Autowired
    DepartmentsService departmentsService;

    @GetMapping("/alldepts")
    public List<Departments> getAllDepts(){
        return departmentsService.getAllDepts();
    }

    @GetMapping("/{id}")
    public Departments getDeptById(@PathVariable("id") int id){
        return departmentsService.getDeptById(id);
    }

    @PostMapping("/")
    public void saveDept(@RequestBody Departments dept){
        departmentsService.saveDept(dept);
    }

    @DeleteMapping("/{id}")
    public void deleteDept(@PathVariable("id") int id){
        departmentsService.deleteDept(id);
    }

    @PutMapping("/{id}")
    public void updateDept(@RequestBody Departments dept, @PathVariable("id") int id){
        departmentsService.updateDept(dept,id);
    }
}
