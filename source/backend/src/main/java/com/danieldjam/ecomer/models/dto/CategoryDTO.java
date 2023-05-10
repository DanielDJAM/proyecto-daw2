package com.danieldjam.ecomer.models.dto;

public class CategoryDTO {

    private Integer categoryId;
    private String name;
    private String descripcion;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer categoryId, String name, String descripcion) {
        this.categoryId = categoryId;
        this.name = name;
        this.descripcion = descripcion;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
