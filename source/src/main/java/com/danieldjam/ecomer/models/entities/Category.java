package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
public class Category {
    @Id
    @Column(name = "category_ID", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "description", nullable = false, length = 45)
    private String description;

//    @ToString.Exclude
//    @ManyToMany
//    @JoinTable(name = "Categories_has_Products",
//            joinColumns = @JoinColumn(name = "category_ID"),
//            inverseJoinColumns = @JoinColumn(name = "product_ID"))
//    private Set<Product> products = new LinkedHashSet<>();

}