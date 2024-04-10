package com.example.demo.presentation.request.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    @NotBlank(message = "{product.name.not-blank}")
    @NotNull(message = "{product.name.not-null} ")
    private String name;
    @NotNull(message = "{product.price.not-null}")
    private Double price;
    private String description;
    private String imageUrl;
    @NotNull(message = "{product.stock.not-null}")
    private int stock;

    private int categoryId;
}
