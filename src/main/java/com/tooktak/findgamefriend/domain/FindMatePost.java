package com.tooktak.findgamefriend.domain;

import javax.persistence.*;

@Entity

public class FindMatePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String hashTag;

    @Column(columnDefinition = "TEXT")
    private String kakaoLink;

    @Column(columnDefinition = "TEXT")
    private String discordLink;



    public FindMatePost(String title, String contents, String hashTag, String kakaoLink, String discordLink) {
        this.title = title;
        this.contents = contents;
        this.hashTag = hashTag;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
    }

    public FindMatePost(){

    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public String getHashTag() {
        return hashTag;
    }

    public String getKakaoLink() {
        return kakaoLink;
    }

    public String getDiscordLink() {
        return discordLink;
    }
}
