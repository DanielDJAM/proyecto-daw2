package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.ProductDTO;
import com.danieldjam.ecomer.models.entities.Product;
import com.danieldjam.ecomer.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product newProduct = productRepository.save(convertProductDTOToEntity(productDTO));
        return convertProductEntityToDTO(newProduct);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> convertProductEntityToDTO(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found with productId " + productId));
        return convertProductEntityToDTO(product);
    }

    @Override
    public ProductDTO updateProduct(String productId, ProductDTO productDTO) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found with productId " + productId));
        product.setDescription(productDTO.getDescription());
        product.setName(productDTO.getName());
        product.setStock(productDTO.getStock());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        return convertProductEntityToDTO(productRepository.save(product));
    }

    @Override
    public void deleteProductById(String productId) { productRepository.deleteById(productId); }

    private Product convertProductDTOToEntity(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }

    private ProductDTO convertProductEntityToDTO(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }
}
