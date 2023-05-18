package com.danieldjam.ecomer.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class InvoiceDTO {

    private Integer invoiceId;
    private Integer orderId;
    private Integer quantity;
    private Float unitPrice;
    private Float totalPrice;
    private Float finalPrice;
    private Date invoiceDate;
    private List<Integer> productListDTO = new ArrayList<>();

}
