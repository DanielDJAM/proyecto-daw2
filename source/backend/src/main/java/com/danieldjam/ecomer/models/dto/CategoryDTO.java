package com.danieldjam.ecomer.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CategoryDTO {

    private Integer categoryId;
    private String name;
    private String description;
    @JsonIgnoreProperties(value = {"userId", "categories", "image", "price", "stock", "description"})
    private List<String> products = new ArrayList<>();
}
