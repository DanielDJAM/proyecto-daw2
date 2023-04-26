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
//public class Payment {
//    @EmbeddedId
//    private PaymentId id;
//
//    @ToString.Exclude
//    @MapsId("userId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_ID", nullable = false)
//    private User user;
//
//    @Column(name = "type", length = 45)
//    private String type;
//
//    @Column(name = "transactionHistory", length = 45)
//    private String transactionHistory;
//
//    @OneToOne(mappedBy = "payment")
//    private TransactionHistory paymentId;
//
//}