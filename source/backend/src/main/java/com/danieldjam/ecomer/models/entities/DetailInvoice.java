//package com.danieldjam.ecomer.models.entities;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@Entity
//@Table(name = "Detail_Invoice")
//public class DetailInvoice {
//    @EmbeddedId
//    private DetailInvoiceId id;
//
//    @ToString.Exclude
//    @MapsId("invoiceId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "invoice_ID", nullable = false)
//    private Invoice invoice;
//
//    @ToString.Exclude
//    @MapsId("userId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_ID", nullable = false)
//    private User user;
//
//}