package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "user_ID", nullable = false, length = 50)
    private String id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dni", nullable = false)
    private PersonalData dni;

    @Column(name = "username", nullable = false, length = 16)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "create_time")
    private Date createTime;

//    @ToString.Exclude
//    @OneToMany(mappedBy = "user")
//    private Set<Payment> payments = new LinkedHashSet<>();

//    @ToString.Exclude
//    @OneToMany(mappedBy = "user")
//    private Set<Order> orders = new LinkedHashSet<>();
//
//    @ToString.Exclude
//    @OneToMany(mappedBy = "user")
//    private Set<DetailInvoice> detailInvoices = new LinkedHashSet<>();
//
//    @ToString.Exclude
//    @OneToMany(mappedBy = "user")
//    private Set<Product> products = new LinkedHashSet<>();

//    @ToString.Exclude
//    @ManyToMany
//    @JoinTable(name = "Rol_has_user",
//            joinColumns = @JoinColumn(name = "user_ID"),
//            inverseJoinColumns = @JoinColumn(name = "rol_ID"))
//    private Set<Rol> rols = new LinkedHashSet<>();

}