package com.example.demo.domain.service.interfaces;

import com.example.demo.domain.entity.Category;
import com.example.demo.presentation.request.dto.CategoryDto;
import com.example.demo.presentation.request.dto.ProductDto;
import com.example.demo.presentation.response.pojo.CategoryPojo;
import com.example.demo.presentation.response.pojo.ProductPojo;

import java.util.List;

public interface CategoryService {
    CategoryPojo createCategory(CategoryDto dto);

    List<CategoryPojo> getAll();
    CategoryPojo getCategoryById(int id);
    void deleteCategory(int id);

    Category getCategoryEntityById(int id);
}
