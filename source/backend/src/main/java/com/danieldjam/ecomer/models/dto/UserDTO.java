package com.danieldjam.ecomer.models.dto;


import com.danieldjam.ecomer.models.entities.Order;
import com.danieldjam.ecomer.models.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDTO {

    private Integer userId;
    private String dni;
    private String username;
    private String email;
    private String password;
    private List<Integer> productList = new ArrayList<>();
    private List<Integer> orderList = new ArrayList<>();
    /*private List<Integer> roles;*/
}
