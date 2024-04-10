package com.example.demo.presentation.controller;

import com.example.demo.domain.service.interfaces.CategoryService;
import com.example.demo.presentation.request.dto.CategoryDto;
import com.example.demo.presentation.response.pojo.CategoryPojo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryPojo>> getAll() {
        List<CategoryPojo> categories = categoryService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryPojo> create(@Valid @RequestBody CategoryDto dto) {
        CategoryPojo categorySaved = categoryService.createCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryPojo> getById(@PathVariable Integer id) {
        CategoryPojo categoryFound = categoryService.getCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryFound);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
