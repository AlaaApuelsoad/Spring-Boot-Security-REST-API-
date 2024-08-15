package com.Alaaapuelsoad.security.repository;

import com.Alaaapuelsoad.security.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    //OrderRepository interface extends JpaRepository, providing CRUD operations for the Product entity
}
