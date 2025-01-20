package com.example.menuservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "order-service")  // Name must match the order service registration in Eureka
public interface OrderServiceClient {

    @GetMapping("/orders")
    String getOrders();  // Endpoint to fetch orders from Order Service
}
