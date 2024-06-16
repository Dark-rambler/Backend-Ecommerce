package com.example.demo.presentation.request.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DocumentTypeDto {
    @NotNull(message = "{product.name.not-blank}")
    @NotBlank(message = "{product.name.not-null}")
    private String name;
    private String description;
}
