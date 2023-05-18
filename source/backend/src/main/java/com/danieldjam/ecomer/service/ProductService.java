package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.ProductDTO;
import com.danieldjam.ecomer.models.entities.Product;

import java.util.List;

public interface ProductService {

    public ProductDTO createProduct(ProductDTO productDTO);
    public List<ProductDTO> getAllProducts();
    public ProductDTO getProductById(String productId);
    public ProductDTO updateProduct(String productId, ProductDTO productDTO);
    public  void deleteProductById(String productId);

}
