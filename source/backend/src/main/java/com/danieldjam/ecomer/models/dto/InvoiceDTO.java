package com.danieldjam.ecomer.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;
import java.util.List;

public class InvoiceDTO {

    private Integer invoiceId;
    private Integer userId;
    private Float finalPrice;
    private Date invoiceDate;
    @JsonIgnoreProperties(value = {"stock", "description", "image", "categories"})
    private List<ProductDTO> productDTOList;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Integer invoiceId, Integer userId, Float finalPrice, Date invoiceDate, List<ProductDTO> productDTOList) {
        this.invoiceId = invoiceId;
        this.userId = userId;
        this.finalPrice = finalPrice;
        this.invoiceDate = invoiceDate;
        this.productDTOList = productDTOList;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<ProductDTO> getProductDTOList() {
        return productDTOList;
    }

    public void setProductDTOList(List<ProductDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }
}
