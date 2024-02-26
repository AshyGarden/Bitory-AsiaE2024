package com.example.bitory.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @ToString @Builder
@EqualsAndHashCode
@NoArgsConstructor  @AllArgsConstructor
public class LoginRequestDTO {
    /* 24.02.01
     * Author: CYJ
     * class: LoginRequestDTO // 로그인에 필요한 정보를 전달해주는 DTO
     * */

    @NotBlank
    private String id;

    @NotBlank
    private String pw;

}
