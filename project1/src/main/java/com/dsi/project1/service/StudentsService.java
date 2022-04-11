package com.dsi.project1.service;

import com.dsi.project1.model.Student;
import com.dsi.project1.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    StudentsRepository studentsRepository;

    public List<Student> getAllStudents(){
        return studentsRepository.findAll();
    }

    public Student getStudentById(int id){
        return studentsRepository.findById(id).get();
    }

    public void saveStudent(Student student){
        studentsRepository.save(student);
    }

    public void deleteStudent(int id){
        studentsRepository.deleteById(id);
    }

    public void updateStudent(Student student, int id){
        studentsRepository.findById(id).map(s -> {
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            s.setAge(student.getAge());
            s.setGender(student.getGender());
            return studentsRepository.save(student);
        }).orElseGet(() -> {
            student.setId(id);
            return studentsRepository.save(student);
        });
    }
}
