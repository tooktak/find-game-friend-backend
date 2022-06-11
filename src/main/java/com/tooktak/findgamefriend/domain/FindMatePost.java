package com.tooktak.findgamefriend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FindMatePost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String hashtag;

    @Column(columnDefinition = "TEXT")
    private String kakaoLink;

    @Column(columnDefinition = "TEXT")
    private String discordLink;

    public FindMatePost(String title, String contents, String hashtag, String kakaoLink, String discordLink) {
        this.title = title;
        this.contents = contents;
        this.hashtag = hashtag;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
    }

    public FindMatePost() {
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

    public String getHashtag() {
        return hashtag;
    }

    public String getKakaoLink() {
        return kakaoLink;
    }

    public String getDiscordLink() {
        return discordLink;
    }
}
