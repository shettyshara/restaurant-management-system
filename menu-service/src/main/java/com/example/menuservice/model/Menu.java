package com.example.menuservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Menu {

    @Id
    private Long id;
    private String name;
    private Double price;

    // Getters and Setters
}
