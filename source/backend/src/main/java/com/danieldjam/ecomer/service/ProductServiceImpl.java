package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.ProductDTO;
import com.danieldjam.ecomer.models.entities.Category;
import com.danieldjam.ecomer.models.entities.Product;
import com.danieldjam.ecomer.repository.CategoryRepository;
import com.danieldjam.ecomer.repository.ProductRepository;
import com.danieldjam.ecomer.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        productDTO.setUserId(userRepository.findByEmail(authentication.getName()).get().getUserId());

        mapDtoToEntity(productDTO, product);
        Product newProduct = productRepository.save(product);
        return mapEntityToDto(newProduct);
    }


    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        productList.stream().forEach(product -> {
            ProductDTO productDTO = mapEntityToDto(product);
            productDTOList.add(productDTO);
        });
        return productDTOList;
    }

    @Override
    public ProductDTO getProductById(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found with productId " + productId));
        return mapEntityToDto(product);
    }

    @Transactional
    @Override
    public ProductDTO updateProduct(String productId, ProductDTO productDTO) {
        Product product = productRepository.getOne(productId);
        product.getCategories().clear();
        mapDtoToEntity(productDTO, product);
        return mapEntityToDto(productRepository.save(product));
    }

    @Transactional
    @Override
    public void deleteProductById(String productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()){
            product.get().removeAllCategories();
            productRepository.deleteById(productId);
        }
    }

    @Override
    public Product convertProductDTOToEntity(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }
    @Override
    public ProductDTO convertProductEntityToDTO(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }

    private void mapDtoToEntity(ProductDTO productDTO, Product product){
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        product.setUserId(userRepository.findById(productDTO.getUserId().toString()).get());
        byte[] imageBytes = productDTO.getImage();
        product.setImage(imageBytes);
        if (null == product.getCategories()) {
            product.setCategories(new ArrayList<>());
        }
        productDTO.getCategories().stream().forEach(categoryName -> {
            Category category = categoryRepository.findByName(categoryName);
            if (null == category){
                category = new Category();
                category.setProductList(new ArrayList<>());
            }
            category.setName(categoryName);
            product.addCategory(category);
        });
    }

    private ProductDTO mapEntityToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setStock(product.getStock());
        productDTO.setUserId(product.getUserId().getUserId());
        productDTO.setProductId(product.getProductId());
        productDTO.setCategories(product.getCategories().stream().map(Category::getName).collect(Collectors.toList()));
        productDTO.setImage(product.getImage());
        return productDTO;
    }


}
