package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.AddressDTO;
import java.util.List;

public interface AddressService {

    public AddressDTO createAddress(AddressDTO addressDTO);

    public List<AddressDTO> getAddress();

    public AddressDTO updateAddress(String id, AddressDTO addressDTO);

    public String deleteAddressById(String id);

    public AddressDTO getAddressById(String id);
}
