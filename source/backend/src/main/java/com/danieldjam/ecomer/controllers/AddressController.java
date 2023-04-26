package com.danieldjam.ecomer.controllers;

import com.danieldjam.ecomer.models.dto.AddressDTO;
import com.danieldjam.ecomer.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO addressDTO){
        return new ResponseEntity<>(addressService.createAddress(addressDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<AddressDTO> getAddress() { return addressService.getAddress();}


    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable String id){
        return new ResponseEntity<>(addressService.getAddressById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable String id){
        addressService.deleteAddressById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> editAddressById(@PathVariable String id, @RequestBody AddressDTO addressDTO){
        return new ResponseEntity<>(addressService.updateAddress(id, addressDTO), HttpStatus.OK);
    }



}
