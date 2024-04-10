package com.example.demo.domain.mapper;

import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.Product;
import com.example.demo.presentation.request.dto.CategoryDto;
import com.example.demo.presentation.request.dto.ProductDto;
import com.example.demo.presentation.response.pojo.CategoryPojo;
import com.example.demo.presentation.response.pojo.ProductPojo;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryPojo toPojo( Category category ) {
        CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setId(category.getId());
        categoryPojo.setName(category.getName());
        return categoryPojo;
    }
    public CategoryDto toDto( Category category ) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        return categoryDto;
    }
    public Category fromDto( CategoryDto categoryDto ) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }
    public Category fromPojo(CategoryPojo CategoryPojo ) {
        Category category = new Category();
        category.setId(CategoryPojo.getId());
        category.setName(CategoryPojo.getName());
        return category;
    }
}
