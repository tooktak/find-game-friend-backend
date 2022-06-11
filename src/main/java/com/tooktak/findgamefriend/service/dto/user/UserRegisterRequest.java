package com.tooktak.findgamefriend.service.dto.user;

public class UserRegisterRequest {
    private String userId;
    private String password;
    private String email;
    private String nickName;
    private String pictureURL;

    public UserRegisterRequest(String userId, String password, String email, String nickName, String pictureURL) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.pictureURL = pictureURL;
    }

    public UserRegisterRequest(){}

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPictureURL() {
        return pictureURL;
    }
}
