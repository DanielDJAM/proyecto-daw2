package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class CategoriesHasProductId implements Serializable {
    private static final long serialVersionUID = -2583168118063870793L;
    @Column(name = "category_ID", nullable = false)
    private Integer categoryId;

    @Column(name = "product_ID", nullable = false)
    private Integer productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoriesHasProductId entity = (CategoriesHasProductId) o;
        return Objects.equals(this.categoryId, entity.categoryId) &&
                Objects.equals(this.productId, entity.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, productId);
    }

}