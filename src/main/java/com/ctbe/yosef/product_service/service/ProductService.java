package com.ctbe.yosef.product_service.service;

import com.ctbe.yosef.product_service.dto.*;
import com.ctbe.yosef.product_service.exception.ResourceNotFoundException;
import com.ctbe.yosef.product_service.model.Product;
import com.ctbe.yosef.product_service.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<ProductResponse> findAll() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public ProductResponse findById(Long id) {
        return toResponse(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public ProductResponse create(ProductRequest req) {
        return toResponse(repo.save(toEntity(req)));
    }

    public ProductResponse update(Long id, ProductRequest req) {
        Product existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        existing.setName(req.getName());
        existing.setPrice(req.getPrice());
        existing.setStockQty(req.getStockQty());
        existing.setCategory(req.getCategory());

        return toResponse(repo.save(existing));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        repo.deleteById(id);
    }

    private ProductResponse toResponse(Product p) {
        return new ProductResponse(
                p.getId(),
                p.getName(),
                p.getPrice(),
                p.getStockQty(),
                p.getCategory()
        );
    }

    private Product toEntity(ProductRequest req) {
        return new Product(
                req.getName(),
                req.getPrice(),
                req.getStockQty(),
                req.getCategory()
        );
    }
}