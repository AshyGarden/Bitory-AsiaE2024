package com.example.bitory.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;

@Getter @ToString
@NoArgsConstructor @AllArgsConstructor
@Builder @Entity
@Table(name = "MBRINFM")
public class User {

    /*
     * Author : 최용준
     * Date : 2024/02/20
     * Function : User
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto Increment
    @Column(name = "MBR_NUMBER_PK", length = 100)
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private int mbrNumberPk; //회원번호PK

    @Column(name = "MBR_ID", unique = true, nullable = false, length = 30)
    private String mbrId; //ID

    @Column(name = "MBR_PW",nullable = false, length = 40)
    private String mbrPw; //PW

    @Column(name = "MBR_NAME_KR", nullable = false, length = 30)
    private String mbrNameKr; //이름-한글

    @Column(name = "MBR_NAME_EN", nullable = false, length = 30)
    private String mbrNameEn; //이름-영문

    @Column(name = "MBR_ADDR1", nullable = false, length = 200)
    private String mbrAddr1; //주소1

    @Column(name = "MBR_ADDR2",nullable = false, length = 200)
    private String mbrAddr2; //주소2

    @Column(name = "MBR_KRW", nullable = false)
    private float mbrKrw; //회원의 원화자산

    @CreationTimestamp
    @Column(name = "MBR_JOINDATE")
    private LocalDateTime mbrJoinDate; //가입일자

}
