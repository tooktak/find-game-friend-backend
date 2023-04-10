package com.example.crud.v1.domain;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String contents;

   @Column
    private String kakaoLink;

   @Column
    private String discordLink;

   @Column
   private String memberId;

   @Column
   private String gameId;

    public Post(Long id, String title, String contents, String kakaoLink, String discordLink, String memberId, String gameId) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
        this.memberId = memberId;
        this.gameId = gameId;
    }

    public Post(String title, String contents, String kakaoLink, String discordLink, String memberId, String gameId) {
    }

    public Post() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setKakaoLink(String kakaoLink) {
        this.kakaoLink = kakaoLink;
    }

    public void setDiscordLink(String discordLink) {
        this.discordLink = discordLink;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getKakaoLink() {
        return kakaoLink;
    }

    public String getDiscordLink() {
        return discordLink;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getGameId() {
        return gameId;
    }
}
