package com.ctbe.yosef.product_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId", nullable = false)
    private Long id;

    @NotBlank(message = "product name must not be blank")
    @Column(nullable = false)
    private String name;

    @Positive(message = "price must be greater than zero")
    @Column(nullable = false)
    private double price;
    public Product(){}
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category Category;

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
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }




}
