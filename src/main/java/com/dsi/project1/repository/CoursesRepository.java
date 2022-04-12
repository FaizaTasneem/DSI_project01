package com.dsi.project1.repository;

import com.dsi.project1.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course, Integer> {
}
