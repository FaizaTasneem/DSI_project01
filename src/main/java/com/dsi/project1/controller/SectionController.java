package com.dsi.project1.controller;


import com.dsi.project1.model.Course;
import com.dsi.project1.model.Section;
import com.dsi.project1.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping("/allsection")
    private List<Section> getAllSections(){
        return sectionService.getAllSection();
    }

    @GetMapping("/{id}")
    public Section getSectionById(@PathVariable("id")int secid){
        return sectionService.getSectionById(secid);
    }

    @PostMapping("/createsec")
    public void saveSection(@RequestBody Section section){
        sectionService.saveSection(section);
    }

    @DeleteMapping("/deletesecid/{id}")
    public void deleteSection(@PathVariable("id") int secid){
        sectionService.deleteSection(secid);
    }

    @PutMapping("/updatesec/{id}")
    public void updateSection(@RequestBody Section section, @PathVariable("id") int secid){
        sectionService.updateSection(section,secid);
    }

}
