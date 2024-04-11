package com.example.demo.presentation.response.pojo;

import com.example.demo.common.Pojo;
import com.example.demo.presentation.response.pojo.enums.InventoryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Pojo
@NoArgsConstructor
@Getter
@Setter
public class ProductPojo {
    private int id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;
    private int stock;
    private String category;
    private InventoryStatus inventoryStatus;
    private int rating;

    public ProductPojo(int id, String name, Double price, String description, String imageUrl, int stock, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.stock = stock;
        this.category = category;
        this.rating = 4;
    }
}
