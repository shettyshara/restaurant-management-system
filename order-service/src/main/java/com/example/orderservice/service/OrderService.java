package com.example.orderservice.service;

import com.example.orderservice.client.MenuServiceClient;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuServiceClient menuServiceClient;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        // Validate if the Menu item exists via Menu Service
        menuServiceClient.getMenuById(order.getMenuId());
        return orderRepository.save(order);
    }
}


