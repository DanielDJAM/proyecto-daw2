package com.danieldjam.ecomer.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<String> invoiceList = new ArrayList<>();

}
