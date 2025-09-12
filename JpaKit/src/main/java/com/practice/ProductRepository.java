package com.practice;

import com.practice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);

    List<Product> findByPriceOrQuantity(BigDecimal price, Integer quantity);

    Product findByTitleAndPrice(String title, BigDecimal price);
}
