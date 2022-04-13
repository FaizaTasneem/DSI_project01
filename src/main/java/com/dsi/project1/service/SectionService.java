package com.dsi.project1.service;


import com.dsi.project1.model.Section;
import com.dsi.project1.model.Student;
import com.dsi.project1.repository.SectionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {


    @Autowired
    private SectionRespository sectionRespository;

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
            s.setSecname(section.getSecname());
            return sectionRespository.save(section);
        }).orElseGet(() -> {
            section.setSecid(secid);
            return sectionRespository.save(section);
        });
    }
}
