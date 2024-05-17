package com.example.taskrest.controller;

import com.example.taskrest.dto.ProductRequest;
import com.example.taskrest.entity.Product;
import com.example.taskrest.exception.ProductNotFoundException;
import com.example.taskrest.service.ProductService;
import com.example.taskrest.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Product saveProduct(@RequestBody @Valid ProductRequest productRequest){
        return productService.saveProduct(productRequest);
    }

    @PutMapping("{id}")
    public Constants updateProduct(@PathVariable("id") Long id, @RequestBody @Valid ProductRequest productRequest){
        return productService.updateProduct(id,productRequest);
    }

    @DeleteMapping("{id}")
    public Constants deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }

    @GetMapping("{id}")
    public  Product getProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
