package com.dsi.project1.repository;

import com.dsi.project1.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
}
