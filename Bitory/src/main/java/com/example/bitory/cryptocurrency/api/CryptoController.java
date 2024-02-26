package com.example.bitory.cryptocurrency.api;

import com.example.bitory.cryptocurrency.dto.request.CryptoRequestDTO;
import com.example.bitory.cryptocurrency.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CryptoController {

    private final CryptoService cryptoService;

//    @GetMapping("/market")
//    public ResponseEntity<?> getCrypto(@RequestBody CryptoRequestDTO requestDTO){
//        return null;
//    }

}
