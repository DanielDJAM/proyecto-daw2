package com.danieldjam.ecomer.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvoiceProductDTO {

    @JsonIgnore
    private Integer invoiceProductId;
    @JsonIgnore
    private Integer productInvoiceId;
    private Integer productId;
    private Integer invoiceId;
    private Integer providerId;
    private String productName;
    private Integer quantity;
    private Float unitPrice;
    private Float totalPrice;

}
