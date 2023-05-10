package com.danieldjam.ecomer.repository;

import com.danieldjam.ecomer.models.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, String> {

    public Optional<Roles> findByName(String id);

}
