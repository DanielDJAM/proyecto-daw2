package com.danieldjam.ecomer.models.dto;


public class UserDTO {

    private String id;
    private String dni;
    private String username;
    private String email;
    private String password;
    private String creationTime;

    public UserDTO() {
    }

    public UserDTO(String id, String dni, String username, String email, String password, String creationTime) {
        this.id = id;
        this.dni = dni;
        this.username = username;
        this.email = email;
        this.password = password;
        this.creationTime = creationTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsername() {
        return username;
    }

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

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creationTime='" + creationTime + '\'' +
                '}';
    }
}
