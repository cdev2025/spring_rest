package com.example.restadvanced.service;

import com.example.restadvanced.dto.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    public String login(LoginRequest request){
        // 실제 서비스에서는 DB조회, 비밀번호 검증이 필요
        return UUID.randomUUID().toString(); // 실습용: UUID를 세션 ID처럼 사용
    }
}
