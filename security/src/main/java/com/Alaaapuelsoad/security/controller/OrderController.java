package com.Alaaapuelsoad.security.controller;

import com.Alaaapuelsoad.security.model.Order;
import com.Alaaapuelsoad.security.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/orders/{id}")
    public Optional<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        return orderService.updateOrder(id, orderDetails);
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "order with id - "+id+" Deleted successfully";
    }
}
