package com.example.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "menu-service") // Matches the service name in Eureka
public interface MenuServiceClient {

    @GetMapping("/menus/{id}")
    String getMenuById(@PathVariable Long id);
}
