package com.dsi.project1.controller;


import com.dsi.project1.model.Course;
import com.dsi.project1.model.Section;
import com.dsi.project1.model.Student;
import com.dsi.project1.service.SectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionsController {

    @Autowired
    private SectionsService sectionService;

    @GetMapping("/all")
    private List<Section> getAllSections(){
        return sectionService.getAllSection();
    }

    @GetMapping("/{id}")
    public Section getSectionById(@PathVariable("id")int secid){
        return sectionService.getSectionById(secid);
    }

    @PostMapping
    public void saveSection(@RequestBody Section section){
        sectionService.saveSection(section);
    }

    @DeleteMapping("/delsec/{id}")
    public void deleteSection(@PathVariable("id") int secid){
        sectionService.deleteSection(secid);
    }

    @PutMapping("/editsec/{id}")
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
    @PutMapping("/{secid}/addstd/{stdid}")
    public Section addStudentToSection(@PathVariable("secid")int cid, @PathVariable("stdid") int sid){
        return sectionService.addStudent(cid,sid);
    }
    @PutMapping ("/{secid}/delstd/{stdId}")
    public Section removeStudentFromSection(@PathVariable("secid")int cid, @PathVariable("stdid") int sid){
        return sectionService.removeStudent(cid,sid);
    }

    @PutMapping("/{sid}/addfac/{tid}")
    public Section addTeacher(@PathVariable("sid")int sid, @PathVariable("tid") int tid){
        return sectionService.addTeacher(sid,tid);
    }
    @PutMapping ("/{sid}/delfac/{tid}")
    public Section removeTeacher(@PathVariable("sid")int sid, @PathVariable("tid") int tid){
        return sectionService.removeTeacher(sid,tid);
    }
}
