package com.danieldjam.ecomer.repository;

import com.danieldjam.ecomer.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    User findByUserId(String userId);
    public Boolean existsByUsername(String username);
    public Boolean existsByEmail(String email);
}
