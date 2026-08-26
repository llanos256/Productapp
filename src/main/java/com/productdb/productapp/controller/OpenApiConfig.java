package com.productdb.productapp.controller;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Productapp documentation",
        version = "1.0",
        description = ""
    )
)
public class OpenApiConfig {
}
