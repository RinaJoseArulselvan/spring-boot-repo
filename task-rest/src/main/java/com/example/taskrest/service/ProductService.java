package com.example.taskrest.service;

import com.example.taskrest.dto.ProductRequest;
import com.example.taskrest.entity.Product;
import com.example.taskrest.exception.ProductNotFoundException;
import com.example.taskrest.utils.Constants;

import java.util.List;

public interface ProductService {
    Product saveProduct(ProductRequest productRequest);

    Constants updateProduct(Long id ,ProductRequest productRequest);

    Product getProductById(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Constants deleteProduct(Long id);


}
