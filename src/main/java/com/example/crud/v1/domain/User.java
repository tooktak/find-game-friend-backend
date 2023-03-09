package com.example.crud.v1.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,length = 20)
    private String userName;

    @Column(nullable = false,length = 255)
    private String password;

    @Column(nullable = false,length = 100)
    private String eMail;

    @Column(nullable = false, length = 20,unique = true)
    private String nickName;

    public User(String email, String name, String accessToken) {

    }

    public User() {
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

    public User(Long id, String userName, String password, String eMail, String nickName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
        this.nickName = nickName;
    }
}
