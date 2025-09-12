package com.practice;

import com.practice.entities.Product;
import com.practice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JpaKitApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testRepository() {
        Product product = Product.builder()
                .sku("iphone1787")
                .title("iphone 17")
                .price(BigDecimal.valueOf(120000))
                .quantity(10)
                .build();

        Product savedProduct = productRepository.save(product);
        System.out.println(savedProduct);
    }

    @Test
    void getRepository() {
        List<Product> productsByTitle = productRepository.findByTitle("iphone 17");
        List<Product> productsByPriceOrQuantity = productRepository.findByPriceOrQuantity(BigDecimal.valueOf(78000.00), 5);
        Product productByTitleAndPrice = productRepository.findByTitleAndPrice("iphone 17", BigDecimal.valueOf(120000));
        System.out.println(productsByTitle);
        System.out.println(productsByPriceOrQuantity);
        System.out.println(productByTitleAndPrice);
    }


}
