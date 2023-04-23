package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.AddressDTO;
import com.danieldjam.ecomer.models.entities.*;
import com.danieldjam.ecomer.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServicesImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = convertAddressDTOToEntity(addressDTO);
        Address newAddress = addressRepository.save(address);
        return convertAddressEntityToDTO(newAddress);
    }

    @Override
    public List<AddressDTO> getAddress() {
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream().map(address -> convertAddressEntityToDTO(address)).collect(Collectors.toList());
    }

    @Override
    public AddressDTO updateAddress(String id , AddressDTO addressDTO) {
        Address address = addressRepository.findById(id).get();

        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setStreet(addressDTO.getStreet());
        address.setDataResidence(addressDTO.getDataResidence());
        address.setPostalCode(addressDTO.getPostalCode());

        addressRepository.save(address);

        return convertAddressEntityToDTO(address);
    }

    @Override
    public String deleteAddressById(String id) {
        addressRepository.deleteById(id);
        if (!addressRepository.existsById(id)) {
            return "Address Deleted Successfully";
        }
        return "Failed to Delete Address";

    }

    @Override
    public AddressDTO getAddressById(String id) {
        return convertAddressEntityToDTO(addressRepository.findById(id).get());
    }

    private Address convertAddressDTOToEntity(AddressDTO addressDTO){
        Address address = new Address();

        address.setAddressId(addressDTO.getAddressId());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setStreet(addressDTO.getStreet());
        address.setDataResidence(addressDTO.getDataResidence());
        address.setPostalCode(addressDTO.getPostalCode());

        return address;
    };

    private AddressDTO convertAddressEntityToDTO(Address address){
        AddressDTO AddressDTO = new AddressDTO();

        AddressDTO.setAddressId(address.getAddressId());
        AddressDTO.setCity(address.getCity());
        AddressDTO.setState(address.getState());
        AddressDTO.setCountry(address.getCountry());
        AddressDTO.setStreet(address.getStreet());
        AddressDTO.setDataResidence(address.getDataResidence());
        AddressDTO.setPostalCode(address.getPostalCode());

        return AddressDTO;
    };
}
