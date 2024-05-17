package com.example.taskrest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ProductRequest {
    @NotEmpty(message = "name cannot be null")
    private String name;
    private String description;
    @NotNull(message = "price should not be null")
    private Double price;
    private int quantity;
}
