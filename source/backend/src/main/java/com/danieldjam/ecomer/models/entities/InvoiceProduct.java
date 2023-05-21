package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoice_has_products")
@IdClass(InvoiceProductId.class)
public class InvoiceProduct {

    @Id
    private Integer invoiceProductId;

    @Id
    private Integer productInvoiceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "invoice_id_fk5"), name = "invoice_id", insertable = false, updatable = false)
    private Invoice invoiceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "product_id_fk5"), name = "product_id", insertable = false, updatable = false)
    private Product productId;

    @Column(name = "provider_id")
    private Integer providerId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private Float unitPrice;

    @Column(name = "total_price")
    private Float totalPrice;

}
