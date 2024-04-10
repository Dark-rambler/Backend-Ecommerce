package com.example.demo.presentation.controller;

import com.example.demo.domain.service.interfaces.ProductService;
import com.example.demo.presentation.request.dto.ProductDto;
import com.example.demo.presentation.response.pojo.ProductPojo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductPojo>> getAll() {
        List<ProductPojo> products = productService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping
    public ResponseEntity<ProductPojo> create(@Valid @RequestBody ProductDto dto) {
        ProductPojo productSaved = productService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPojo> getById(@PathVariable Integer id) {
        ProductPojo productFound = productService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productFound);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
