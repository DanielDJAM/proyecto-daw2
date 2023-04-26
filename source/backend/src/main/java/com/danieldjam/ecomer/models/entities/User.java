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
@Entity(name = "User")//mirarlo
@Table(name = "User")
public class User {
    @Id
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @OneToOne
    @JoinColumn(name = "dni", nullable = false)
    private PersonalData dni;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

}