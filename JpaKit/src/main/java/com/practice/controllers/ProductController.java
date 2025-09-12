package com.practice.controllers;

import com.practice.entities.Product;
import com.practice.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(defaultValue = "id") String sortBy) {
//        return productRepository.findAllByOrderByPrice();
        return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "price"));
    }


}
