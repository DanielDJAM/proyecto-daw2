package com.danieldjam.ecomer.models.dto;

import com.danieldjam.ecomer.models.entities.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
public class ProductDTO{

    private Integer productId;
    private Integer userId;
    private String name;
    private Integer stock;
    private Float price;
    private String description;
    private byte[] image;
    @JsonIgnoreProperties(value = {"products"})
    private List<String> categories = new ArrayList<>();

    public ProductDTO() {
    }

    public ProductDTO(Integer productId, Integer userId, String name, Integer stock, Float price, String description, byte[] image) {
        this.productId = productId;
        this.userId = userId;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.image = image;
    }

}
