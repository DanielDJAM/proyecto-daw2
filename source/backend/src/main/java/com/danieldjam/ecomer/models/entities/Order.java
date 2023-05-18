package com.danieldjam.ecomer.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(name = "arrivalDate")
    private Date arrivalDate;

    @Column(name = "estimatedDate")
    private Date estimatedDate;

    @Column(name = "departureDate")
    private Date departureDate;

    @Column(name = "initialLocation")
    private String initialLocation;

    @Column(name = "finalLocation")
    private String finalLocation;

    @Column(name = "status_order")
    private String statusOrder;

}