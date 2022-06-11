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

    @Column(nullable = false, length = 20)
    private String nickName;

    @Column(columnDefinition = "TEXT")
    private String pictureURL;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    public Member(String memberId, String password, String email, String nickName, String pictureURL, MemberType memberType) {
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.pictureURL = pictureURL;
        this.memberType = memberType;
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


