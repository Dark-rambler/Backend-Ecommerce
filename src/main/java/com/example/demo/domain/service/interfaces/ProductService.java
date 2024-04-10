package com.example.demo.domain.service.interfaces;

import com.example.demo.domain.entity.Product;
import com.example.demo.presentation.request.dto.ProductDto;
import com.example.demo.presentation.response.pojo.ProductPojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductPojo create(ProductDto dto);
    List<ProductPojo> getAll();
    ProductPojo getById(int id);
    Page<ProductPojo> getProducts(Pageable pageable);
    void delete(int id);

}
