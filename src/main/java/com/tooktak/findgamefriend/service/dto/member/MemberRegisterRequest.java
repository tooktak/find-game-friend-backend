package com.tooktak.findgamefriend.service.dto.member;

public class MemberRegisterRequest {
    private String MemberId;
    private String password;
    private String email;
    private String nickName;
    private String pictureURL;

    public MemberRegisterRequest(String MemberId, String password, String email, String nickName, String pictureURL) {
        this.MemberId = MemberId;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.pictureURL = pictureURL;
    }

    public MemberRegisterRequest(){}

    public String getMemberId() {
        return MemberId;
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
