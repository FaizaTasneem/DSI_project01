package com.dsi.project1.repository;

import com.dsi.project1.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachersRepository extends JpaRepository<Teacher, Integer> {

}
