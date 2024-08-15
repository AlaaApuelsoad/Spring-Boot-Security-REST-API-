package com.Alaaapuelsoad.security.service;

import com.Alaaapuelsoad.security.model.Order;
import com.Alaaapuelsoad.security.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository ordersRepository) {
        this.orderRepository = ordersRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Optional<Order> getOrderById(long id){
        return orderRepository.findById(id);
    }
    @Transactional
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    @Transactional
    public Optional<Order> updateOrder(long id ,Order orderDetails){
        return orderRepository.findById(id).map(order -> {
            order.setProductId(orderDetails.getProductId());
            order.setQuantity(orderDetails.getQuantity());
            return orderRepository.save(order);
        });
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
        System.out.println("order with id - "+id+" Deleted successfully");

    }
}
