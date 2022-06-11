package com.tooktak.findgamefriend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

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
    private String hashTag;

    @Column(columnDefinition = "TEXT")
    private String kakaoLink;

    @Column(columnDefinition = "TEXT")
    private String discordLink;

    @Column
    private LocalDateTime latestPullUpDateTime;

    public FindMatePost(String title, String contents, String hashTag, String kakaoLink, String discordLink, LocalDateTime latestPullUpDateTime) {
        this.title = title;
        this.contents = contents;
        this.hashTag = hashTag;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
        this.latestPullUpDateTime = latestPullUpDateTime;
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
