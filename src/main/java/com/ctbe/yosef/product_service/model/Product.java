package com.ctbe.yosef.product_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "product name must not be blank")
    @Column(nullable = false)
    private String name;

    @Positive(message = "price must be greater than zero")
    @Column(nullable = false)
    private double price;
    public Product(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Positive(message = "price must be greater than zero")
    public double getPrice() {
        return price;
    }

    public void setPrice(@Positive(message = "price must be greater than zero") double price) {
        this.price = price;
    }

    public @NotBlank(message = "product name must not be blank") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "product name must not be blank") String name) {
        this.name = name;
    }

    public Product(String name, double price){
        this.name = name;
        this.price= price;



    }
}
