package com.example.restadvanced.repository;

import com.example.restadvanced.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // 상품 등록시 중복 상품명 검색
    boolean existsByName(String name);
}
