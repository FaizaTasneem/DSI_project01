package com.dsi.project1.controller;


import com.dsi.project1.model.Section;
import com.dsi.project1.model.Student;
import com.dsi.project1.service.SectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectionsController {

    @Autowired
    private SectionsService sectionService;

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

    @PutMapping("/{sid}/addcourse/{cid}")
    public Section addToCourse(@PathVariable("sid")int sid, @PathVariable("cid") int cid){
        return sectionService.addToCourse(sid,cid);
    }

    @PutMapping ("/{sid}/delcourse/{cid}")
    public Section removeFromCourse(@PathVariable("sid")int sid, @PathVariable("cid") int cid){
        return sectionService.removeFromCourse(sid,cid);
    }

}
