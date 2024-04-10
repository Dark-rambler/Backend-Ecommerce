package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Store API",
                version = "0.0.1",
                description = "API para gestionar la tienda, incluyendo categorías y productos"
        )
)
public class SwaggerConfig {

}

