package com.example.restadvanced.config;

import com.example.restadvanced.entity.Product;
import com.example.restadvanced.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // CommandLineRunner는 Spring Boot 애플리케이션이 실행된 직후 한 번 실행됩니다.
        // H2 DB테스트용 상품 3개 미리 저장
        productRepository.save(new Product("기계식 키보드", 89000));
        productRepository.save(new Product("무선 마우스", 39990));
        productRepository.save(new Product("USB-C 허브", 45000));
    }
}
