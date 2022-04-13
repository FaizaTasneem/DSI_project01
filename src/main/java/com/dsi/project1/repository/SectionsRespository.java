package com.dsi.project1.repository;

import com.dsi.project1.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionsRespository extends JpaRepository<Section, Integer> {
}
