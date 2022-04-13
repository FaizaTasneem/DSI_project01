package com.dsi.project1.service;

import com.dsi.project1.model.Student;
import com.dsi.project1.model.Teacher;
import com.dsi.project1.repository.TeachersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServices {

    @Autowired
    TeachersRespository teachersRespository;


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
            s.setDept(teacher.getDept());
            return teachersRespository.save(teacher);
        }).orElseGet(() -> {
            teacher.setTid(tid);
            return teachersRespository.save(teacher);
        });
    }
}
