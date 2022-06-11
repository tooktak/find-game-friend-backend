package com.tooktak.findgamefriend.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FindMatePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true,length = 100)
    private String postId;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String hashTag;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String kakaoLink;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String discordLink;

    public FindMatePost(Long id, String postId, String contents, String hashTag, String kakaoLink, String discordLink) {
        this.id = id;
        this.postId = postId;
        this.contents = contents;
        this.hashTag = hashTag;
        this.kakaoLink = kakaoLink;
        this.discordLink = discordLink;
    }

    public Long getId() {
        return id;
    }

    public String getPostId() {
        return postId;
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
