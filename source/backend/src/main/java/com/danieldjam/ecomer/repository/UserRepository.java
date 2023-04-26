package com.danieldjam.ecomer.repository;

import com.danieldjam.ecomer.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
