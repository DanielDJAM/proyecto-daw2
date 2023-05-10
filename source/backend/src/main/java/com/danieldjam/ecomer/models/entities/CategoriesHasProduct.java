package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "categories_has_products")
public class CategoriesHasProduct {

    @Id
    @ManyToOne
    @JoinColumn(name = "has_category_id")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "has_product_id")
    private Product product;




}