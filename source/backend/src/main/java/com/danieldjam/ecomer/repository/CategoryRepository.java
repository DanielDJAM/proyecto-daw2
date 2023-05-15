package com.danieldjam.ecomer.repository;

import com.danieldjam.ecomer.models.dto.CategoryDTO;
import com.danieldjam.ecomer.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    public Category findByName(String name);
}
