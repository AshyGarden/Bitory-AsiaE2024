package com.example.bitory.cryptocurrency.repository;

import com.example.bitory.cryptocurrency.entity.Crypto;
import com.example.bitory.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CryptoRepository extends JpaRepository<Crypto, String> {
    /* 24.02.21
     * Author: CYJ
     * function: findByNameKr(이메일로 회원정보 조회기능)
     * */

    Optional<Crypto> findByCycNameKr(String cycNameKr); //Query Method
    Optional<Crypto> findByCycNameEn(String cycNameEn); //Query Method

    //해당 암호화폐의 거래횟수(tdeCount)를 반환
//    @Query("SELECT COUNT(*) FROM Crypto c WHERE c.cycTdeCount :cycTdeCount")
//    int countCryptoTde(@Param("cycTdeCount") Crypto crypto);

    //해당 암호화폐의 즐겨찾기수(favCount)를 반환
//    @Query("SELECT COUNT(*) FROM Crypto c WHERE c.cycFavCount")

}
