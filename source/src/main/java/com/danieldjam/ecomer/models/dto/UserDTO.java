package com.danieldjam.ecomer.models.dto;


public class UserDTO {

    private String userId;
    private PersonalDataDTO dni;
    private String username;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String userId, PersonalDataDTO dni, String username, String email, String password) {
        this.userId = userId;
        this.dni = dni;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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


    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + userId + '\'' +
                ", dni='" + dni + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
