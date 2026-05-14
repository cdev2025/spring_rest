package com.example.restadvanced.controller;

import com.example.restadvanced.dto.ProductCreateRequest;
import com.example.restadvanced.dto.ProductResponse;
import com.example.restadvanced.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Tag(name="Product API", description = "상품 조회 및 등록 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // http://localhost:8080/api/products/1
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id){
        ProductResponse response = productService.findById(id);

        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS).cachePrivate())
                .eTag("\"product-" + id + "\"") // "product-1"
                .body(response);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @Valid @RequestBody ProductCreateRequest request
    ){
        ProductResponse response = productService.create(request);

        return ResponseEntity
                .created(URI.create("/api/products/" + response.getId()))
                .body(response);
    }

}
