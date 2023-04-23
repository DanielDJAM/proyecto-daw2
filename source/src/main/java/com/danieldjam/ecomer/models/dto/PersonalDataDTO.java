package com.danieldjam.ecomer.models.dto;

public class PersonalDataDTO {

    private String dni;
    private AddressDTO addressId;
    private Integer age;
    private String genre;
    private String name;
    private String surname;

    public PersonalDataDTO() {
    }

    public PersonalDataDTO(String dni, AddressDTO addressId, Integer age, String genre, String name, String surname) {
        this.dni = dni;
        this.addressId = addressId;
        this.age = age;
        this.genre = genre;
        this.name = name;
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public AddressDTO getAddressId() {
        return addressId;
    }

    public void setAddressId(AddressDTO addressId) {
        this.addressId = addressId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
