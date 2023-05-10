package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @Column(name = "rol_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rolId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

}