package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Transaction_History")
public class TransactionHistory {
    @Id
    @Column(name = "payment_ID", nullable = false)
    private Integer id;

//    @ToString.Exclude
//    @MapsId
//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumns({
//            @JoinColumn(name = "payment_ID", referencedColumnName = "payment_ID", nullable = false),
//            @JoinColumn(name = "payment_user_ID", referencedColumnName = "user_ID", nullable = false)
//    })
//    private Payment payment;

    @Column(name = "operationType", length = 45)
    private String operationType;

    @Column(name = "transactionDate", length = 45)
    private String transactionDate;

    @Column(name = "quantity", length = 45)
    private String quantity;

    @Column(name = "`ID origen`", length = 45)
    private String iDOrigen;

    @Column(name = "`ID destino`", length = 45)
    private String iDDestino;

}