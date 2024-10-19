package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Order;
import com.example.demo.Repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public ResponseEntity<Order> createOrder(Order order) {
        return ((ResponseEntity<Order>) orderRepository).ok(order);
    }

    public Order updateOrder(Long orderId, Order order) {
        order.setOrderId(orderId);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}

