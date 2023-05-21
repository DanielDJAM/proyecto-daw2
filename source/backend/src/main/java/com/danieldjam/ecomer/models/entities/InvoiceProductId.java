package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class InvoiceProductId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "invoice_id")
    private Integer invoiceProductId;

    @Column(name = "product_id")
    private Integer productInvoiceId;
}
