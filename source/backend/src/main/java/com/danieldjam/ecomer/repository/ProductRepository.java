package com.danieldjam.ecomer.repository;

import com.danieldjam.ecomer.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {


}
