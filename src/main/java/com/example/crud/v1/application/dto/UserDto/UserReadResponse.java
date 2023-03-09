package com.example.crud.v1.application.dto.UserDto;

public class UserReadResponse {
    private Long id;
    private String userName;
    private String password;
    private String eMail;
    private String nickName;

    public UserReadResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public UserReadResponse(Long id, String userName, String password, String eMail, String nickName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
        this.nickName = nickName;
    }
}
