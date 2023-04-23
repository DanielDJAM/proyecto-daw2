package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Product {
    @EmbeddedId
    private ProductId id;

    @ToString.Exclude
    @MapsId("userId")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_ID", nullable = false)
    private User user;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "stock", length = 45)
    private Integer stock;

    @Column(name = "price", length = 45)
    private Float price;

    @Column(name = "description", length = 45)
    private String description;

    @Column(name = "image", length = 45)
    private String image;

//    @ToString.Exclude
//    @ManyToMany
//    @JoinTable(name = "Categories_has_Products",
//            joinColumns = @JoinColumn(name = "product_ID"),
//            inverseJoinColumns = @JoinColumn(name = "category_ID"))
//    private Set<Category> categories = new LinkedHashSet<>();

}