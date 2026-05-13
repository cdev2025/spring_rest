package com.example.restadvanced.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Tag(name = "Hello API", description = "간단한 문자열 응답을 반환합니다.")
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello REST API";
    }
}
