package com.ctbe.yosef.product_service;

import com.ctbe.yosef.product_service.dto.ProductResponse;
import com.ctbe.yosef.product_service.exception.ResourceNotFoundException;
import com.ctbe.yosef.product_service.model.Product;
import com.ctbe.yosef.product_service.Repository.ProductRepository;
import com.ctbe.yosef.product_service.service.ProductService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void findById_returnsProduct_whenProductExists() {

        Product laptop = new Product("Laptop", 1200, 10, "Electronics");
        laptop.setId(1L);

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(laptop));

        ProductResponse result = productService.findById(1L);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Laptop");
        assertThat(result.getPrice()).isEqualTo(1200);
    }

    @Test
    void findById_throwsException_whenProductNotFound() {

        when(productRepository.findById(99L))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.findById(99L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("99");
    }
}