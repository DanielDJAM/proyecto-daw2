package com.danieldjam.ecomer.repository;

import com.danieldjam.ecomer.models.entities.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepository extends JpaRepository<PersonalData, String> {
}
