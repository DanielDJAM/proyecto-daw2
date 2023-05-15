package com.danieldjam.ecomer.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
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
    @Column(name = "invoice_id", nullable = false)
    private Integer invoiceId;

    @ManyToOne
    @JoinColumn(name = "invoice_user_id", nullable = false)
    private User userId;

    @Column(name = "final_price")
    private Float finalPrice;

    @Column(name = "invoice_date")
    private Date invoiceDate;

//    @OneToMany
//    @JoinColumn(name = "product_id", nullable = false)
//    private List<Product> productList;
}