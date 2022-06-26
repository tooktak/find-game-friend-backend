package com.tooktak.findgamefriend.domain;

import javax.persistence.*;

@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String pictureURL;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    public Member(String password, String email, String name, String pictureURL, AuthProvider authProvider) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.pictureURL = pictureURL;
        this.authProvider = authProvider;
    }

    public Member() {

    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public AuthProvider getAuthProvider() {
        return authProvider;
    }
}


