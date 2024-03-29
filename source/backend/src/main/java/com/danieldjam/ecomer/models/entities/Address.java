package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String addressId;

    @ManyToOne
    @JoinColumn(name = "dni")
    private PersonalData dni;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "data_residence")
    private String dataResidence;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "state")
    private String state;

    @Column(name = "street")
    private String street;

}