package com.example.demo.domain.service.implement;

import com.example.demo.data.repository.CategoryRepository;
import com.example.demo.domain.entity.Category;
import com.example.demo.domain.entity.Product;
import com.example.demo.domain.mapper.CategoryMapper;
import com.example.demo.domain.service.interfaces.CategoryService;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.presentation.request.dto.CategoryDto;
import com.example.demo.presentation.request.dto.ProductDto;
import com.example.demo.presentation.response.pojo.CategoryPojo;
import com.example.demo.presentation.response.pojo.ProductPojo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public CategoryPojo createCategory(CategoryDto dto) {
        Category category = categoryMapper.fromDto(dto);
        categoryRepository.save(category);
        return categoryMapper.toPojo(category);
    }

    @Override
    public List<CategoryPojo> getAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return toPojoList(categoryList);
    }

    @Override
    public CategoryPojo getCategoryById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Category", id));
        return categoryMapper.toPojo(category);
    }

    @Override
    public void deleteCategory(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Category", id));
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategoryEntityById(int id) {
        return categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Category", id));
    }


    private List<CategoryPojo> toPojoList(List<Category> categoryList) {
        List<CategoryPojo> categoryPojoList = categoryList.stream().map((entity)->
                categoryMapper.toPojo(entity)).toList();
        return categoryPojoList;
    }
}
