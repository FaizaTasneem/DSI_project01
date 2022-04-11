package com.dsi.project1.repository;

import com.dsi.project1.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Department, Integer> {
}
