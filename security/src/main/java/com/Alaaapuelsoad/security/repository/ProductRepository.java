package com.Alaaapuelsoad.security.repository;

import com.Alaaapuelsoad.security.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //ProductRepository interface extends JpaRepository, providing CRUD operations for the Product entity
}
