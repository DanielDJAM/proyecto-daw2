package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.CategoryDTO;
import com.danieldjam.ecomer.models.dto.ProductDTO;
import com.danieldjam.ecomer.models.entities.Category;
import com.danieldjam.ecomer.models.entities.Product;
import com.danieldjam.ecomer.repository.CategoryRepository;
import com.danieldjam.ecomer.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategorySerciveImpl implements CategoryService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Transactional
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(convertCategoryDTOToEntity(categoryDTO));
        return convertCategoryEntityToDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();
        categoryList.stream().forEach(category -> {
            CategoryDTO categoryDTO = mapEntityToDto(category);
            categoryDTOList.add(categoryDTO);
        });
        return categoryDTOList;
    }

    @Override
    public CategoryDTO getCategoryById(String categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Category not found with categoryId " + categoryId));
        return convertCategoryEntityToDTO(category);
    }

    @Transactional
    @Override
    public CategoryDTO updateCategory(String categoryId, CategoryDTO categoryDTO) {
        Category category = categoryRepository.getOne(categoryId);
        category.getProductList().clear();
        mapDtoToEntity(categoryDTO, category);
        return mapEntityToDto(categoryRepository.save(category));
    }

    @Transactional
    @Override
    public void deleteCategoryById(String categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            category.get().removeAllProducts();
            categoryRepository.deleteById(categoryId);
        }
    }

    public CategoryDTO convertCategoryEntityToDTO(Category category){ return modelMapper.map(category, CategoryDTO.class);}

    public Category convertCategoryDTOToEntity(CategoryDTO categoryDTO){ return modelMapper.map(categoryDTO, Category.class);}

    private void mapDtoToEntity(CategoryDTO categoryDTO, Category category) {
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        if (null == category.getProductList()) {
            category.setProductList(new ArrayList<>());
        }
        categoryDTO.getProducts().stream().forEach(productName -> {
            Product product = productRepository.findByName(productName);
            if (null == product) {
                product = new Product();
                product.setCategories(new ArrayList<>());
            }
            product.setName(productName);
            product.addCategory(category);
        });
    }

    private CategoryDTO mapEntityToDto(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        categoryDTO.setCategoryId(category.getId());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setProducts(category.getProductList().stream().map(Product::getName).collect(Collectors.toList()));
        return categoryDTO;
    }



}
