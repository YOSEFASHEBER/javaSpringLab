package com.ctbe.yosef.product_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Product Service API",
		version = "1.0.0",
		description = "RESTful Product Catalogue — Lab 2"
))
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}