package com.tooktak.findgamefriend.domain;

import javax.persistence.*;

@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String memberId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20, unique = true)
    private String nickName;

    @Column(columnDefinition = "TEXT")
    private String pictureURL;

    public Member(String memberId, String password, String email, String nickName, String pictureURL) {
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.pictureURL = pictureURL;
    }

    public Member() {

    }

    public Long getId() {
        return id;
    }

    public String getMemberId() {
        return memberId;
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


