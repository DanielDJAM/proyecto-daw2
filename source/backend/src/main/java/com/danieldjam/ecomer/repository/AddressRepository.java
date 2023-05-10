package com.danieldjam.ecomer.repository;

import com.danieldjam.ecomer.models.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
