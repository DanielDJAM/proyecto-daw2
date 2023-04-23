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
@Table(name = "`Order`")
public class Order {
    @EmbeddedId
    private OrderId id;

    @ToString.Exclude
    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_ID", nullable = false)
    private User user;

    @ToString.Exclude
    @MapsId("invoiceId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoice_ID", nullable = false)
    private Invoice invoice;

    @Column(name = "arrivalDate", nullable = false, length = 45)
    private String arrivalDate;

    @Column(name = "estimatedDate", nullable = false, length = 45)
    private String estimatedDate;

    @Column(name = "departureDate", nullable = false, length = 45)
    private String departureDate;

    @Column(name = "initialLocation", nullable = false, length = 45)
    private String initialLocation;

    @Column(name = "finalLocation", nullable = false, length = 45)
    private String finalLocation;

}