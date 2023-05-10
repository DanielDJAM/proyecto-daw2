package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.AddressDTO;
import com.danieldjam.ecomer.models.entities.*;
import com.danieldjam.ecomer.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private ModelMapper modelMapper;
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
    public void deleteAddressById(String id) {
        addressRepository.deleteById(id);
    }

    @Override
    public AddressDTO getAddressById(String id) {
        return convertAddressEntityToDTO(addressRepository.findById(id).get());
    }

    @Override
    public Address convertAddressDTOToEntity(AddressDTO addressDTO){
        return modelMapper.map(addressDTO, Address.class);
    };

    @Override
    public AddressDTO convertAddressEntityToDTO(Address address){
        return modelMapper.map(address, AddressDTO.class);
    };
}
