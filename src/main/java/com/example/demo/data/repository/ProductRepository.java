package com.example.demo.data.repository;

import com.example.demo.domain.entity.Product;
import com.example.demo.presentation.response.pojo.ProductPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM Product", nativeQuery = true)
    List<Product> findProductsWithCategoryName();

    @Query("SELECT NEW com.example.demo.presentation.response.pojo.ProductPojo(p.id, p.name, p.price, p.description, p.imageUrl, p.stock, c.name) FROM Product p JOIN p.category c")
    List<ProductPojo> findProductsWithCategoryNames();

}
