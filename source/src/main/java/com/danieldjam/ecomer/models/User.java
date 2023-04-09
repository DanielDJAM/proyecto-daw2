package com.danieldjam.ecomer.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "User")
@Entity
@ToString @EqualsAndHashCode
public class User {

    @Getter @Setter @Column(name = "user_ID")
    @Id
    private String userId;
    @Getter @Setter @Column(name = "dni")
    private String dni;
    @Getter @Setter @Column(name = "username")
    private String username;
    @Getter @Setter @Column(name = "email")
    private String email;
    @Getter @Setter @Column(name = "password")
    private String password;
    @Getter @Setter @Column(name = "create_time")
    private String creationTime;


}
