package com.danieldjam.ecomer.models.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties("password")
public class UserDTO {

    private Integer userId;
    private PersonalDataDTO dni;
    private String username;
    private String email;
    private String password;
    //private Set<RolesDTO> roles;

    public UserDTO() {
    }

    public UserDTO(Integer userId, PersonalDataDTO dni, String username, String email, String password, Set<RolesDTO> roles) {
        this.userId = userId;
        this.dni = dni;
        this.username = username;
        this.email = email;
        this.password = password;
        //this.roles = roles;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public PersonalDataDTO getDni() {
        return dni;
    }

    public void setDni(PersonalDataDTO dni) {
        this.dni = dni;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
