package com.example.demo.presentation.response.pojo;

import com.example.demo.common.Pojo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Pojo
@NoArgsConstructor
@AllArgsConstructor
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
}
