package com.danieldjam.ecomer.models.dto;

import java.sql.Blob;

public class ProductDTO {

    private Integer productId;
    private Integer userId;
    private String name;
    private Integer stock;
    private Float price;
    private String description;
    private byte[] image;

    public ProductDTO() {
    }

    public ProductDTO(Integer productId, UserDTO userId, String name, Integer stock, Float price, String description, byte[] image) {
        this.productId = productId;
        this.userId = userId.getUserId();
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
