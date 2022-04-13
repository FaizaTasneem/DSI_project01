package com.dsi.project1.service;


import com.dsi.project1.model.Course;
import com.dsi.project1.model.Department;
import com.dsi.project1.model.Section;
import com.dsi.project1.model.Student;
import com.dsi.project1.repository.CoursesRepository;
import com.dsi.project1.repository.SectionsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionsService {


    @Autowired
    private SectionsRespository sectionRespository;

    @Autowired
    private CoursesRepository coursesRepository;

    public List<Section> getAllSection(){

        return sectionRespository.findAll();
    }

    public Section getSectionById(int secid){
        return sectionRespository.findById(secid).get();
    }

    public void saveSection(Section section){
        sectionRespository.save(section);
    }

    public void deleteSection(int secid){
        sectionRespository.deleteById(secid);
    }

    public void updateSection(Section section, int secid){
        sectionRespository.findById(secid).map(s -> {
            s.setName(section.getName());
            return sectionRespository.save(section);
        }).orElseGet(() -> {
            section.setId(secid);
            return sectionRespository.save(section);
        });
    }

    public Section addToCourse(int sid, int did) {
        Section section = sectionRespository.findById(sid).get();
        Course course = coursesRepository.findById(did).get();
        section.addToCourse(course);
        return sectionRespository.save(section);
    }

    public Section removeFromCourse(int sid, int did) {
        Section section = sectionRespository.findById(sid).get();
        Course course = coursesRepository.findById(did).get();
        section.setCourse(null);
        course.deleteSection(section);
        return sectionRespository.save(section);
    }
}
