package com.example.crud.v1.application.Oauth;


public class TokenEmptyException extends RuntimeException {

    public TokenEmptyException(){
        super("토큰이 존재하지 않습니다");
        //https://github.com/spy03128/NawaNolza/blob/8053f6f6d41524f7ef8e23dad24e63ab3704ff0c/nawanolza/server/src/main/java/ssafy/nawanolza/server/domain/exception/TokenEmptyException.java
        //참조

    }
}
