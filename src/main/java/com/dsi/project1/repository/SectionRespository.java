package com.dsi.project1.repository;

import com.dsi.project1.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SectionRespository extends JpaRepository<Section, Integer> {
}
