package com.example.restadvanced.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    // 오류 메시지를 JSON 형태로 내려주기 위한 응답 DTO
    // 예: {"message": "상품을 찾을 수 없습니다."}
    private String message;
}
