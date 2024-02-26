package com.example.bitory.user.dto.request;

import com.example.bitory.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString @Builder
public class UserSignUpRequestDTO {

    @NotBlank
    private String id;

    @NotBlank
    private String password;

    @NotBlank
    private String nameKr;

    @NotBlank
    private String nameEn;

    @NotBlank
    private  String addr1;

    @NotBlank
    private  String addr2;

    @NotBlank
    private float krw;

    public User toEntity() {
        return User.builder()
                .mbrId(this.id)
                .mbrPw(this.password)
                .mbrNameKr(this.nameKr)
                .mbrNameEn(this.nameEn)
                .mbrAddr1(this.addr1)
                .mbrAddr2(this.addr2)
                .mbrKrw(this.krw)
                .build();
    }

}
