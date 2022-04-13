package com.dsi.project1.service;

import com.dsi.project1.model.Course;
import com.dsi.project1.model.Department;
import com.dsi.project1.model.Student;
import com.dsi.project1.repository.CoursesRepository;
import com.dsi.project1.repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsService {

    @Autowired
    DepartmentsRepository departmentsRepository;

    public List<Department> getAllDepts(){
        return departmentsRepository.findAll();
    }

    public Department getDeptById(int id){
        return departmentsRepository.findById(id).get();
    }

    public void saveDept(Department dept){
        departmentsRepository.save(dept);
    }

    public void deleteDept(int id){
        departmentsRepository.deleteById(id);
    }

    public void updateDept(Department dept, int id){
        departmentsRepository.findById(id).map(d -> {
            d.setName(dept.getName());
            return departmentsRepository.save(dept);
        }).orElseGet(() -> {
            dept.setId(id);
            return departmentsRepository.save(dept);
        });
    }


}
