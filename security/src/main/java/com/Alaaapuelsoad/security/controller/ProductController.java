package com.Alaaapuelsoad.security.controller;

import com.Alaaapuelsoad.security.model.Product;
import com.Alaaapuelsoad.security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/products/{id}")
    public Optional<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "product with id - "+id+" Deleted successfully";
    }
}
