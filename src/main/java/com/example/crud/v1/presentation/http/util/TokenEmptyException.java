package com.example.crud.v1.presentation.http.util;


public class TokenEmptyException extends RuntimeException {

    public TokenEmptyException(){
        super("토큰이 존재하지 않습니다");
    }
}
