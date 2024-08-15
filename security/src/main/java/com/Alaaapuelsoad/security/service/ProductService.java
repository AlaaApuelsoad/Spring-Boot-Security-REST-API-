package com.Alaaapuelsoad.security.service;

import com.Alaaapuelsoad.security.model.Product;
import com.Alaaapuelsoad.security.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }

    @Transactional
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Transactional
    public Optional<Product> updateProduct(long id,Product productDetails){
        return productRepository.findById(id).map(product -> {
            product.setProductName(productDetails.getProductName());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);

        });
    }

    @Transactional
    public void deleteProduct(long id){
        productRepository.deleteById(id);
        System.out.println("product with id - "+id+" Deleted successfully");

    }
}
