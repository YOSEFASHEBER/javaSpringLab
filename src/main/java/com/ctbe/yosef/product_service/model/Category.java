package com.ctbe.yosef.product_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private Long categoryId;


    @Column(name = "categoryName")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

}
