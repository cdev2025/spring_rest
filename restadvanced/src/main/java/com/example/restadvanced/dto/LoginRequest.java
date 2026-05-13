package com.example.restadvanced.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "로그인 요청 DTO")
public class LoginRequest {

    @Schema(description = "이메일", example = "test@test.com")
    @NotBlank(message = "이메일은 필수입니다.")
    String email;

    @Schema(description = "패스워드", example = "1234")
    @NotBlank(message = "비밀번호는 필수입니다.")
    String password;
}
