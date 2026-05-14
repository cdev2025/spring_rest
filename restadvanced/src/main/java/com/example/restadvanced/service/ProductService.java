package com.example.restadvanced.service;

import com.example.restadvanced.dto.ProductCreateRequest;
import com.example.restadvanced.dto.ProductResponse;
import com.example.restadvanced.entity.Product;
import com.example.restadvanced.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("상품을 찾을 수 없습니다."));

        // entity => dto변환해서 반환
        return ProductResponse.builder()
                .price(product.getPrice())
                .name(product.getName())
                .id(product.getId())
                .build();
//        return new ProductResponse(
//                product.getId(),
//                product.getName(),
//                product.getPrice()
//        );
    }

    @Transactional
    public ProductResponse create(ProductCreateRequest request){
        // 비즈니스 로직 처리가 서비스의 역할
        // 상품명 중복 확인이 중요한 비즈니스 규칙
        if( productRepository.existsByName(request.getName())){
            throw new IllegalArgumentException(("이미 등록된 상품입니다."));
        }

        Product product = new Product(request.getName(), request.getPrice());

        Product savedProduct = productRepository.save(product);

        // entity => 응답 DTO로 변환해서 반환
        return ProductResponse.builder()
                .id(savedProduct.getId())
                .name(savedProduct.getName())
                .price(savedProduct.getPrice())
                .build();
    }
}


