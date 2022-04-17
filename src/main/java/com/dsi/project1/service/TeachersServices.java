package com.dsi.project1.service;

import com.dsi.project1.model.Department;
import com.dsi.project1.model.Teacher;
import com.dsi.project1.repository.DepartmentsRepository;
import com.dsi.project1.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachersServices {

    @Autowired
    TeachersRepository teachersRespository;
    @Autowired
    DepartmentsRepository departmentsRepository;

    public List<Teacher> getAllTeachers(){
        return  teachersRespository.findAll();
    }

    public Teacher getTeachersById(int tid){

        return teachersRespository.findById(tid).get();
    }

    public void saveTeachers(Teacher teacher){
        teachersRespository.save(teacher);
    }

    public void deleteTeacher(int tid){

        teachersRespository.deleteById(tid);
    }
    public void updateTeacher(Teacher teacher, int tid){
        teachersRespository.findById(tid).map(s -> {
            s.setName(teacher.getName());
            s.setGender(teacher.getGender());
            s.setAge(teacher.getAge());
            return teachersRespository.save(teacher);
        }).orElseGet(() -> {
            teacher.setId(tid);
            return teachersRespository.save(teacher);
        });
    }

    public Teacher addToDept(int tid, int did) {
        Teacher teacher = teachersRespository.findById(tid).get();
        Department department = departmentsRepository.findById(did).get();
        teacher.addToDept(department);
        return teachersRespository.save(teacher);
    }

    public Teacher removeFromDept(int tid, int did) {
        Teacher teacher = teachersRespository.findById(tid).get();
        Department department = departmentsRepository.findById(did).get();
        teacher.setDepartment(null);
        department.deleteTeacher(teacher);
        return teachersRespository.save(teacher);
    }
}
