package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.CategoryDTO;
import com.danieldjam.ecomer.models.dto.ProductDTO;
import com.danieldjam.ecomer.models.entities.Category;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryService {
    public CategoryDTO createCategory(CategoryDTO categoryDTO);
    public List<CategoryDTO> getAllCategories();
    public CategoryDTO getCategoryById(String categoryId);
    public CategoryDTO updateCategory(String categoryId, CategoryDTO categoryDTO);
    public void deleteCategoryById(String categoryId);
}
