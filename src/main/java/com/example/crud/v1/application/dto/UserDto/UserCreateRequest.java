package com.example.crud.v1.application.dto.UserDto;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCreateRequest {
    public UserCreateRequest() {
    }

    private String userName;
    private String password;
    private String eMail;
    private String nickName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserCreateRequest(String userName, String password, String eMail, String nickName) {
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
        this.nickName = nickName;
    }
}
