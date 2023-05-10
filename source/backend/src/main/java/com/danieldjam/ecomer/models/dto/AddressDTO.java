package com.danieldjam.ecomer.models.dto;

public class AddressDTO {

    private Integer addressId;
    private String country;
    private String city;
    private String state;
    private String street;
    private String dataResidence;
    private String postalCode;

    public AddressDTO() {
    }

    public AddressDTO(Integer addressId, String country, String city, String state, String street, String dataResidence, String postalCode) {
        this.addressId = addressId;
        this.country = country;
        this.city = city;
        this.state = state;
        this.street = street;
        this.dataResidence = dataResidence;
        this.postalCode = postalCode;
    }


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDataResidence() {
        return dataResidence;
    }

    public void setDataResidence(String dataResidence) {
        this.dataResidence = dataResidence;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "addressId='" + addressId + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                ", dataResidence='" + dataResidence + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
