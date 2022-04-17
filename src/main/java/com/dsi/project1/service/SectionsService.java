package com.dsi.project1.service;


import com.dsi.project1.model.Course;
import com.dsi.project1.model.Section;
import com.dsi.project1.model.Student;
import com.dsi.project1.model.Teacher;
import com.dsi.project1.repository.CoursesRepository;
import com.dsi.project1.repository.SectionsRepository;
import com.dsi.project1.repository.StudentsRepository;
import com.dsi.project1.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionsService {


    @Autowired
    private SectionsRepository sectionRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    TeachersRepository teachersRepository;

    public List<Section> getAllSection(){

        return sectionRepository.findAll();
    }

    public Section getSectionById(int secid){
        return sectionRepository.findById(secid).get();
    }

    public void saveSection(Section section){
        sectionRepository.save(section);
    }

    public void deleteSection(int secid){
        sectionRepository.deleteById(secid);
    }

    public void updateSection(Section section, int secid){
        sectionRepository.findById(secid).map(s -> {
            s.setName(section.getName());
            return sectionRepository.save(section);
        }).orElseGet(() -> {
            section.setId(secid);
            return sectionRepository.save(section);
        });
    }

    public Section addToCourse(int sid, int did) {
        Section section = sectionRepository.findById(sid).get();
        Course course = coursesRepository.findById(did).get();
        section.addToCourse(course);
        return sectionRepository.save(section);
    }

    public Section removeFromCourse(int sid, int did) {
        Section section = sectionRepository.findById(sid).get();
        Course course = coursesRepository.findById(did).get();
        section.setCourse(null);
        course.deleteSection(section);
        return sectionRepository.save(section);
    }

    public Section addStudent(int sectionId, int studentId){
        Section section = sectionRepository.findById(sectionId).get();
        Student student = studentsRepository.findById(studentId).get();
        section.addStudent(student);
        return sectionRepository.save(section);
    }

    public Section removeStudent(int sectionId, int studentId){
        Section section = sectionRepository.findById(sectionId).get();
        Student student = studentsRepository.findById(studentId).get();
        section.removeStudent(student);
        return sectionRepository.save(section);
    }
    public Section addTeacher(int sectionId, int teacherId){
        Section section = sectionRepository.findById(sectionId).get();
        Teacher teacher = teachersRepository.findById(teacherId).get();
        section.addTeacher(teacher);
        return sectionRepository.save(section);
    }

    public Section removeTeacher(int sectionId, int teacherId){
        Section section = sectionRepository.findById(sectionId).get();
        Teacher teacher = teachersRepository.findById(teacherId).get();
        section.setTeacher(null);
        teacher.setSection(null);
        return sectionRepository.save(section);
    }

}
