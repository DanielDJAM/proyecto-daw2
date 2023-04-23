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
@Table(name = "Categories_has_Products")
public class CategoriesHasProduct {

    @ToString.Exclude
    @Id
    @MapsId("categoryId")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_ID", nullable = false)
    private Category category;

//    @ToString.Exclude
//    @MapsId("productId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumns({
//            @JoinColumn(name = "product_ID", referencedColumnName = "product_ID", nullable = false),
//            @JoinColumn(name = "user_ID", referencedColumnName = "user_ID", nullable = false)
//    })
//    private Product product;

}