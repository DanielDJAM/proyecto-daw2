package com.danieldjam.ecomer.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PersonalDataDTO {

    private String dni;
    private AddressDTO addressId;
    private Date birthdate;
    private String genre;
    private String name;
    private String surname;
}
