package com.example.demo.domain.mapper;

import com.example.demo.domain.entity.Product;
import com.example.demo.presentation.request.dto.ProductDto;
import com.example.demo.presentation.response.pojo.ProductPojo;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductPojo toPojo(Product product) {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setId(product.getId());
        productPojo.setName(product.getName());
        productPojo.setPrice(product.getPrice());
        productPojo.setDescription(product.getDescription());
        productPojo.setImageUrl(product.getImageUrl());
        productPojo.setStock(product.getStock());
        return productPojo;
    }
    public ProductDto toDto( Product product ) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setStock(product.getStock());
        productDto.setCategoryId(product.getCategory().getId());
        return productDto;
    }
    public Product fromDto( ProductDto productDto ) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setStock(productDto.getStock());
        return product;
    }
    public Product fromPojo( ProductPojo productPojo ) {
        Product product = new Product();
        product.setId(productPojo.getId());
        product.setName(productPojo.getName());
        product.setPrice(productPojo.getPrice());
        product.setDescription(productPojo.getDescription());
        product.setImageUrl(productPojo.getImageUrl());
        product.setStock(productPojo.getStock());
        return product;
    }
}
