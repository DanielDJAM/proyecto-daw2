package com.danieldjam.ecomer.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CategoryDTO {

    private Integer categoryId;

    private String name;
    private String description;
    @JsonIgnoreProperties(value = {"userId", "categories", "image", "price", "stock", "description"})
    private List<String> products = new ArrayList<>();

    public CategoryDTO() {
    }

    public CategoryDTO(Integer categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

}
