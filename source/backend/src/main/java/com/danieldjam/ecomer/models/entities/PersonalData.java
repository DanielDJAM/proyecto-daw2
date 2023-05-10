package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Personal_Data")
public class PersonalData {
    @Id
    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @OneToOne
    @JoinColumn( name = "address_id", nullable = false)
    private Address addressId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

    @Column(name = "genre", nullable = false)
    private String genre;


}