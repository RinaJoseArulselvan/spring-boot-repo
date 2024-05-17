package com.example.taskrest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    @NotNull(message = "price cannot be null")
    private float price;
    @NotNull(message = "quantity cannot be null")
    private int quantity;
}
