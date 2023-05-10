package com.danieldjam.ecomer.models.dto;

public class TokenDTO {

    private String token;
    private String type = "Bearer";

    public TokenDTO() {
    }

    public TokenDTO(String token) {
        this.token = token;
    }

    public TokenDTO(String token, String type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
