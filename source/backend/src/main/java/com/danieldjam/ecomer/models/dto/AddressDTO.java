package com.danieldjam.ecomer.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddressDTO {

    private Integer addressId;
    private String dni;
    private String country;
    private String city;
    private String state;
    private String street;
    private String dataResidence;
    private String postalCode;

}
