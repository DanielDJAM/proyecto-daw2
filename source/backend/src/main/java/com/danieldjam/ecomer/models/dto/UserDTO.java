package com.danieldjam.ecomer.models.dto;


import com.danieldjam.ecomer.models.entities.Order;
import com.danieldjam.ecomer.models.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties("password")
public class UserDTO {

    private Integer userId;
    private PersonalDataDTO dni;
    private String username;
    private String email;
    private String password;
    private List<String> productList;
    private List<String> orderList;
    private List<Integer> roles;
}
