package com.example.bitory.user.dto.response;

import com.example.bitory.user.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserSignUpResponseDTO {

    private String id;
    private String password;
    private String nameKr;
    private String nameEn;
    private String addr1;
    private String addr2;
    private float krw;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime joinDate;

    public UserSignUpResponseDTO(User user) {
        this.id = user.getMbrId();
        this.password = user.getMbrPw();
        this.nameKr = user.getMbrNameKr();
        this.nameEn = user.getMbrNameEn();
        this.joinDate = user.getMbrJoinDate();
        this.addr1 = user.getMbrAddr1();
        this.addr2 = user.getMbrAddr2();
        this.krw = user.getMbrKrw();
    }

}
