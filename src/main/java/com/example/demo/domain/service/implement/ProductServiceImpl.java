package com.example.demo.domain.service.implement;

import com.example.demo.data.repository.ProductRepository;
import com.example.demo.domain.entity.Product;
import com.example.demo.domain.mapper.ProductMapper;
import com.example.demo.domain.service.interfaces.CategoryService;
import com.example.demo.domain.service.interfaces.ProductService;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.presentation.request.dto.ProductDto;
import com.example.demo.presentation.response.pojo.CategoryPojo;
import com.example.demo.presentation.response.pojo.ProductPojo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;

    @Override
    public ProductPojo create(ProductDto dto) {
        Product product = productMapper.fromDto(dto);
        product.setCategory(categoryService.getCategoryEntityById(dto.getCategoryId()));
        productRepository.save(product);
        CategoryPojo categoryPojo = categoryService.getCategoryById(dto.getCategoryId());
        ProductPojo productPojo = productMapper.toPojo(product);
        productPojo.setCategory(categoryPojo.getName());
        return productPojo;
    }

    @Override
    public List<ProductPojo> getAll() {
        List<ProductPojo> list = productRepository.findProductsWithCategoryNames();
        System.out.println(list);
        return list;
    }
    @Override
    public ProductPojo getById(int id) {

        Product product = productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Product", id));
        ProductPojo productPojo = productMapper.toPojo(product);
        CategoryPojo categoryPojo = categoryService.getCategoryById(product.getCategory().getId());
        productPojo.setCategory(categoryPojo.getName());
        return productPojo;
    }

    @Override
    public Page<ProductPojo> getProducts(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(int id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Product", id));
        productRepository.deleteById(id);
    }
    private List<ProductPojo> toPojoList(List<Product> productList) {
        return productList.stream().map(productMapper::toPojo).toList();
    }
}
