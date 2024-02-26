package com.example.bitory.user.api;

import com.example.bitory.order.service.OrderService;
import com.example.bitory.user.dto.request.LoginRequestDTO;
import com.example.bitory.user.dto.request.UserSignUpRequestDTO;
import com.example.bitory.user.dto.response.LoginResponseDTO;
import com.example.bitory.user.dto.response.UserSignUpResponseDTO;
import com.example.bitory.user.entity.User;
import com.example.bitory.user.repository.UserRepository;
import com.example.bitory.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController @Slf4j
@RequiredArgsConstructor
@RequestMapping("/join")
public class UserController {

    private final UserService userService;
//    private final OrderService orderService;

    /*
     * Author : 최용준
     * Date : 2024/02/22
     * Function : duplCheck
     * */
    //ID 중복 확인 요청 처리
    //GET: /join/idDuplCheck?id
//    @GetMapping("/idDuplCheck")
//    public ResponseEntity<?> duplCheck(String id) {
//        if(id.trim().equals("")) {
//            return ResponseEntity.badRequest()
//                    .body("입력한 id가 없습니다!"); //id공란 return
//        }
//
////        boolean resultFlag = userService.isDuplicate(id);
//
//        if(!resultFlag){
//            log.info("입력하신 `{id}`는 사용중인 아이디 입니다.");
//        } else{
//            log.info("입력하신 아이디 사용가능합니다.");
//        }
//
//        return ResponseEntity.ok().body(resultFlag);
//    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup( @RequestBody UserSignUpRequestDTO requestDTO ) {

        UserSignUpResponseDTO responseDTO;
        try {
            responseDTO = userService.create(requestDTO);
            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /* 24.02.01
    * Author: CYJ
    * function: Sign In(Login)
    * */
    @GetMapping("/signin")
    public ResponseEntity<?> singIn(@Validated @RequestBody LoginRequestDTO dto){
        try {
            LoginResponseDTO responseDTO = userService.authenticate(dto);
            return  ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
