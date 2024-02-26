package com.example.bitory.user.repository;

import com.example.bitory.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    /* 24.02.01
     * Author: CYJ
     * function: findByMbrId(id로 회원정보 조회기능)
     * */
    Optional<User> findByMbrId(String mbrId); //Query Method

    // function: existsByMbrId(id 중복 조회기능)
//    boolean existsByMbrId(String mbrId);
}
