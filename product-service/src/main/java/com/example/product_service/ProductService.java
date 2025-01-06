package com.example.product_service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> getProductById(Long id) {
    return productRepository.findById(id);
  }

  public Product updateProduct(Long id, Product updatedProduct) {
    return productRepository.findById(id).map(product -> {
      product.setName(updatedProduct.getName());
      product.setPrice(updatedProduct.getPrice());
      return productRepository.save(product);
    }).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
}
