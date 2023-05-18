package com.danieldjam.ecomer.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;

    @JoinColumn(name = "order_id")
    @JsonManagedReference
    @ManyToOne
    private Order orderId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private Float unitPrice;

    @Column(name = "total_price")
    private Float totalPrice;

    @Column(name = "final_price")
    private Float finalPrice;

    @Column(name = "invoice_date")
    private Date invoiceDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "invoice_has_products", joinColumns = @JoinColumn(name = "invoice_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonBackReference
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        this.productList.add(product);
        product.getInvoiceList().add(this);
    }

    public void removeProduct(Product product){
        this.productList.remove(product);
        product.getInvoiceList().remove(this);
    }

    public void removeAllProducts(){
        for (Product product : new ArrayList<>(productList)) {
            removeProduct(product);
        }
    }

}