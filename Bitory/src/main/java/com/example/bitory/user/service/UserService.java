package com.example.bitory.user.service;

import com.example.bitory.user.dto.request.LoginRequestDTO;
import com.example.bitory.user.dto.request.UserSignUpRequestDTO;
import com.example.bitory.user.dto.response.LoginResponseDTO;
import com.example.bitory.user.dto.response.UserSignUpResponseDTO;
import com.example.bitory.user.entity.User;
import com.example.bitory.user.repository.UserRepository;
import com.example.bitory.utils.exception.DuplicatedIdException;
import com.example.bitory.utils.exception.NoRegisteredArgumentsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserSignUpResponseDTO create(final UserSignUpRequestDTO requestDTO) throws RuntimeException {

        String id = requestDTO.getId();

        // ID Not Found
        if(requestDTO == null){
            throw new NoRegisteredArgumentsException("아이디 입력 정보가 존재하지 않습니다.");
        }

        // ID is duplicated
//        if(isDuplicate(id)){
//            log.warn("{}는 존재하는 아이디 입니다.",id);
//            throw new DuplicatedIdException("존재하는 아이디 입니다.");
//        }

//        //패스워드 인코딩
//        String encoded = encoder.encode(requestDTO.getPassword());
//        requestDTO.setPassword(encoded);
//
//        //유저 엔터티로 변환
          User user = requestDTO.toEntity();
//
//        User saved = userRepository.save(user);
//
//        log.info("회원 가입 정상 수행됨! - saved user - {}", saved);

        return new UserSignUpResponseDTO(user);
    }

    // function: isDuplicate(id 중복확인)
//    public boolean isDuplicate(String id) {
//        return userRepository.existsById(id);
//    }

    /* 24.02.01
     * Author: CYJ(최용준)
     * function: authenticate(인증)
     * */
    public LoginResponseDTO authenticate(final LoginRequestDTO dto) {

        //id를 통해 회원 정보를 조회.
        User user = userRepository.findById(dto.getId()).orElseThrow(
                () -> new RuntimeException("가입된 회원이 아닙니다.")
        );

        //비밀번호 검증
        String writtenPassword = dto.getPw(); //사용자가 입력한 비번
        String dbPassword = user.getMbrPw(); //DB에 저장된 비번

        if(writtenPassword == null){
            throw new RuntimeException("비밀번호를 입력하지 않으셨습니다.");
        } else if(!writtenPassword.equals(dbPassword)) {
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        } else{
            log.info("{}님 로그인 성공!", user.getMbrNameKr());
            log.info("{} Login Success!", user.getMbrNameEn());
        }

        return new LoginResponseDTO(user);
    }

}
