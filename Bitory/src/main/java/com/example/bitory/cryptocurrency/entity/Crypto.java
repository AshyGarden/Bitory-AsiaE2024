package com.example.bitory.cryptocurrency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Builder @Entity //@EqualsAndHashCode(of="cycNumberPk")
@Table(name = "CYCINFM")
public class Crypto {

    /*
     * Author : 최용준
     * Date : 2024/02/20
     * Function : Crypto
     * */

    @Id
    @Column(name = "CYC_NUMBER_PK", length = 100)
    private int cycNumberPk; //암호화폐PK

    @Column(name = "CYC_NAME_KR", nullable = false, length = 40)
    private String cycNameKr; //이름-한글

    @Column(name = "CYC_NAME_EN", nullable = false, length = 40)
    private String cycNameEn; //이름-영문

    @Column(name = "CYC_NAME_ABBR", length = 20)
    private String cycNameAbbr; //이름-약어

    @Column(name = "CYC_TDE_COUNT",nullable = false, length = 40)
    private int cycTdeCount; //해당 암호화폐 거래수

    @Column(name = "CYC_FAV_COUNT",nullable = false, length = 40)
    private int cycFavCount; //해당 암호화폐 즐겨찾기 관심수

}
