package com.example.taskrest.service;

import com.example.taskrest.dto.ProductRequest;
import com.example.taskrest.entity.Product;
import com.example.taskrest.exception.ProductNotFoundException;
import com.example.taskrest.repository.ProductRepository;
import com.example.taskrest.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product saveProduct(ProductRequest productRequest) {
        Product product = Product.build(0L,productRequest.getName(),
                productRequest.getDescription(),productRequest.getPrice(),productRequest.getQuantity());
        return productRepository.save(product);
    }

    @Override
    public Constants updateProduct(Long id , ProductRequest productRequest)  {
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            return Constants.UPDATION_FAILED;
        }else {
            product.setName(productRequest.getName());
            product.setDescription(productRequest.getDescription());
            product.setPrice(productRequest.getPrice());
            product.setQuantity(productRequest.getQuantity());
            productRepository.save(product);
             return Constants.UPDATED;
        }
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException{
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            throw new ProductNotFoundException("product not found");
        }else {
            return product;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Constants deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            return Constants.DELETION_FAILED;
        }else {
            productRepository.deleteById(id);
            return Constants.DELETED;
        }
    }
}
