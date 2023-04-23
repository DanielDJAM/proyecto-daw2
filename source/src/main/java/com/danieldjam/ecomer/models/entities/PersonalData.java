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
@Table(name = "Personal_Data")
public class PersonalData {
    @Id
    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @OneToOne
    @JoinColumn( name = "address_id", nullable = false)
    private Address addressId;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "surname", nullable = false, length = 45)
    private String surname;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "genre", nullable = false, length = 45)
    private String genre;


}