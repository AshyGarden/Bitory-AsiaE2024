package com.example.bitory.utils.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DuplicatedIdException extends RuntimeException{
    public DuplicatedIdException(String message) {
        super(message);
    }
}
