package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Rol {
    @Id
    @Column(name = "rol_ID", nullable = false, length = 45)
    private String id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description")
    private String description;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "Rol_has_user",
            joinColumns = @JoinColumn(name = "rol_ID"),
            inverseJoinColumns = @JoinColumn(name = "user_ID"))
    private Set<User> users = new LinkedHashSet<>();

}