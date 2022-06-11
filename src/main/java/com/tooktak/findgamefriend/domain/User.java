package com.tooktak.findgamefriend.domain;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String nickName;

    @Column(columnDefinition = "TEXT")
    private String pictureURL;

    public User(String userId, String password, String email, String nickName, String pictureURL) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.pictureURL = pictureURL;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

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


