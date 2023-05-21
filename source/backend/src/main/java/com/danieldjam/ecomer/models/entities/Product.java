package com.danieldjam.ecomer.models.entities;

import com.danieldjam.ecomer.models.entities.Category;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "user_id"), name = "user_id")
    @JsonManagedReference
    private User userId;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "categories_has_products", joinColumns = @JoinColumn(name = "has_product_id"), inverseJoinColumns = @JoinColumn(name = "has_category_id"))
    @JsonBackReference
    private List<Category> categories;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceProduct> invoiceList = new ArrayList<>();

    public void addCategory(Category category) {
        this.categories.add(category);
        category.getProductList().add(this);
    }

    public void removeCategory(Category category){
        this.categories.remove(category);
        category.getProductList().remove(this);
    }

    public void removeAllCategories(){
        for (Category category : new ArrayList<>(categories)) {
            removeCategory(category);
        }
    }

}