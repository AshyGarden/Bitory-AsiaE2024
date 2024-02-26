package com.example.bitory.user.dto.response;

import com.example.bitory.user.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter @ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class LoginResponseDTO {

    /* 24.02.01
     * Author: CYJ
     * class: LoginResponseDTO
     * */

    private String id;
    private String nameKr;
    private String nameEn;

    @JsonFormat(pattern = "yyyy년 MM월 dd일")
    private LocalDate joinDate;
//    private String token; // 인증 토큰
//    private String role;  // 권한

    //User 정보를 이용하여 dto를 이용하는 생성자
    public LoginResponseDTO(User user) {
        this.id =  user.getMbrId();
        this.nameKr = user.getMbrNameKr();
        this.nameEn = user.getMbrNameEn();
        this.joinDate = LocalDate.from(user.getMbrJoinDate());
    }
}
