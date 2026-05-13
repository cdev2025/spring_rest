package com.example.restadvanced.service;

import com.example.restadvanced.dto.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductResponse findById(Long id) {
        return new ProductResponse(id, "기계식 키보드", 89000);
    }
}
