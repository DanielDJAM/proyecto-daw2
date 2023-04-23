package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Invoice {
    @Id
    @Column(name = "invoice_ID", nullable = false)
    private Integer id;

    @Column(name = "finalPrice", nullable = false, length = 45)
    private String finalPrice;

    @Column(name = "invoiceDate", nullable = false, length = 45)
    private String invoiceDate;

    @ToString.Exclude
    @OneToMany(mappedBy = "invoice")
    private Set<Order> orders = new LinkedHashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "invoice")
    private Set<DetailInvoice> detailInvoices = new LinkedHashSet<>();

}