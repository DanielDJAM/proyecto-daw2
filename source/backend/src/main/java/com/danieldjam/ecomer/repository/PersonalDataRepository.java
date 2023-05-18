package com.danieldjam.ecomer.repository;

import com.danieldjam.ecomer.models.entities.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonalDataRepository extends JpaRepository<PersonalData, String> {
    Optional<PersonalData> findById(String dni);
}
